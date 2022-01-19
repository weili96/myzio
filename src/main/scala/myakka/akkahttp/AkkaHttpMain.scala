package myakka.akkahttp

import akka.Done
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{Route, RouteResult}

import scala.concurrent.Future
import scala.io.StdIn
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.util.Success

object AkkaHttpMain extends App {

  implicit val system = ActorSystem(Behaviors.empty, "my-system")
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.executionContext


  var orders: List[Item] = List(Item("jwl",10),Item("wl",12))
  final case class Item(name: String, id: Long)
  final case class Order(items: List[Item])


  def fetchItem(itemId: Long): Future[Option[Item]] = Future {
    orders.find(o => o.id == itemId)
  }

  def saveOrder(order:Order): Future[String] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _             => orders
    }
    Future{"ddd"}
  }


  val route1 = path("hello") {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1> Hello AkkaHttp! </h1>"))
    }
  }
  val route2:Route = concat(
    get {
      pathPrefix("item" / LongNumber) { id =>
        val maybeItem = fetchItem(id)
        onSuccess(maybeItem) {
          case Some(item) => complete(item.asJson.noSpaces)
          case None => complete(StatusCodes.NotFound)
        }
      }
    }
  )

  val bindingFuture = Http().newServerAt("0.0.0.0", 9000).bind(route1 ~ route2)

  println(s"Server now online. Please navigate to http://localhost:8080/hello\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())


}

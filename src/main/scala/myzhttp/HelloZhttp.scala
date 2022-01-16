package myzhttp

import zhttp.http._
import zhttp.service.Server
import zio._


object HelloZhttp extends App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = Server.start(8090, app).exitCode

  val app1 = Http.collectM[Request] {
    case Method.GET -> Root => ZIO.succeed(Response.text("Hello World"))
    case Method.GET -> Root / "c" => ZIO.fail(Response.text("error"))
  }

  val app2 = Http.collect[Request] {
    case Method.GET -> Root / "a" => Response.text("Apple")
    case Method.GET -> Root / "b" => Response.text("Banana")
  }

  // Create HTTP route
  val app3: HttpApp[Any, Nothing] = HttpApp.collect {
    case Method.GET -> Root / "text" => Response.text("Hello World!")
    case Method.GET -> Root / "json" => Response.jsonString("""{"greetings": "Hello World!"}""")
  }
  val app = app3

  val a = Http.collect[Request] { case Method.GET -> Root / "a"  => Response.ok }
  val b = Http.collect[Request] { case Method.GET -> Root / "b"  => Response.ok }

  app.silent

//  val app = a.orElse(b)

//  val app = app1 <> app2

}

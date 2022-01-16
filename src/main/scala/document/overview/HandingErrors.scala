package document.overview

import zio._

import java.io.FileNotFoundException

//object HandingErrors extends ZIOAppDefault{
//  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = ???
//
//  // either : takes an ZIO[R, E, A] and produces an ZIO[R, Nothing, Either[E, A]].
//  private val either: URIO[Any, Either[String, Nothing]] = IO.fail("error").either
//
//  either.absolve
//
//  // absolve : turns an ZIO[R, Nothing, Either[E, A]] into a ZIO[R, E, A]:
//  private val value1: ZIO[Any, String, Nothing] = ZIO.absolve(either)
//
//
//
//  // catchAll 捕获所以的异常，并尝试恢复
//  private val value: ZIO[Any, Nothing, String] = ZIO.attempt("hello").catchAll(_ => ZIO.succeed("3"))
//
//  ZIO.attempt("aa").catchSome{
//    case _ : FileNotFoundException => ZIO.fail("22")
//  }
//
//  // try one effect, or, if it fails, try another effect,
//  ZIO.attempt("1").orElse(ZIO.attempt("2"))
//
//  def doA():Option[String] = {
//    Some("1")
//  }
//
//  val a: String = doA().fold("1")(_ => "hello")
//
//  //allow you to handle both failure and success.
//  ZIO.attempt(1).fold(
//    _ => 0,
//    num => num
//  )
//  ZIO.attempt(1).foldZIO(
//    _ => ZIO.fail(1),
//    data => ZIO.succeed(data)
//  )
//
////  retrying failed effects.
//  ZIO.attempt(5).retry(Schedule.recurs(3))
//  ZIO.attempt(6).retryOrElse(Schedule.recurs(3),(_,_:Nothing) => ZIO.attempt(3))
//
//
//
//
//}

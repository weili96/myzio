package ziodemo

import zio.{App, ExitCode, IO, UIO, URIO, ZIO}

object OverView1 extends App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = ???


  private val succeed: ZIO[Any, Nothing, Int] = IO.succeed(21).map(_ * 2)



  private val failed: ZIO[Any, Exception, Nothing] = IO.fail("error!").mapError(msg => new Exception(msg))

  private val failIo: IO[String, Nothing] = IO.fail("error!")


  /**
   *
   * map  mapError
   * flatMap
   * for
   * zip
   * zipLeft/right  (   <*    /     *> )
   *
   */


  /**
   *  handling error
   *
   *
   *  either
   *
   *  absolve
   *
   *  catchAll
   *  catchSome
   *
   *  orElse
   *
   *  fold
   *  foldM
   *
   *  retry
   *  retryOrElse
   *  retryOrElseEither
   */

  def sqrt(io: UIO[Double]): IO[String, Double] =

      io.map(value =>
        if (value < 0.0) Left("Value must be >= 0.0")
        else Right(Math.sqrt(value))
    ).absolve

  private val value: ZIO[Any, Nothing, Int] = IO.fail("xx").catchAll(_ => IO.succeed(3))


//  ZIO.access("ddd").fold()

  /**
   *  resource handling
   *
   *  ensuring
   *
   *  bracket
   */


}

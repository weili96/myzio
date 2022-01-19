package ziodemo

import zio._

object OverView2 extends App{
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = ???


  private val fork: URIO[Any, Fiber.Runtime[Nothing, Int]] = IO.succeed(100).fork

  private val value: ZIO[Any, Nothing, IO[Nothing, Int]] = fork.map(f => f.join)

  private val value1: ZIO[Any, Nothing, UIO[Exit[Nothing, Int]]] = fork.map(f => f.await)

}

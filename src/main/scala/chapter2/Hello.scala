package chapter2

import zio.{Has, ZIO, ZIOAppArgs, ZIOAppDefault}

object Hello extends ZIOAppDefault{
  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = effect.exitCode

  val effect1 = ZIO.effect()

  val effect2 = ZIO.attempt(println("hello zio!"))

  val effect3 = ZIO.attempt(3 + 6)

  def effect4(x: Int) = ZIO.attempt(s"value = $x")

  val effect: ZIO[Any, Throwable, Unit] = for {
    _     <- effect2
    value <- effect3
    str   <- effect4(value)
  } yield (println(str))

}

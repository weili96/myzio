//import zio.Console.{printLine, readLine}
//import zio.{ExitCode, Has, URIO, ZIO, ZIOAppArgs, ZIOAppDefault}
//
//
//object MyApp extends  ZIOAppDefault {
//  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = myAppLogic
//
//  val myAppLogic =
//    for {
//      _     <- printLine("Hello! What's is your name?")
//      name  <- readLine
//      _     <- printLine(s"Hello! ${name}, welcome to ZIO!")
//    } yield ()
//
//}

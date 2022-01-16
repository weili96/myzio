package chapter2

//import zio.Console.printLine
//import zio.{Console, Has, ZIO, ZIOAppArgs, ZIOAppDefault}
//
//import java.io.IOException
//
//object SeqOpts extends ZIOAppDefault{
//  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = printNum.exitCode
//
//  val arr = Array(1,2,3,4,5)
//
//  private val printNum: ZIO[Has[Console], IOException, Array[Unit]] = ZIO.foreach(arr)(n => printLine(n.toString))
//
//}

package document.overview

//import zio.Console.{printLine, readLine}
//import zio.{App, Console, ExitCode, Has, IO, RIO, UIO, URIO, ZIO}
//
//import scala.io.StdIn
//import scala.sys.process.processInternal.IOException
//
///**
// * Exception是Throwable的一个主要子类。
// * Exception下面还有子类，其中一部分子类分别对应于Java程序运行时常常遇到的各种异常的处理，其中包括隐式异常。
// * 比如，程序中除数为0引起的错误、数组下标越界错误等，这类异常也称为运行时异常，因为它们虽然是由程序本身引起的异常，但不是程序主动抛出的，而是在程序运行中产生的。
// *
// * Exception 子类下面的另一部分子类对应于Java程序中的非运行时异常的处理（在下图中将它们直接属于Exception了），这些异常也称为显式异常。
// * 它们都是在程序中用语句抛出、并且也是用语句进行捕获的，比如，文件没找到引起的异常、类没找到引起的异常等。
// */
//
//object CreatingEffect extends App {
//  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = ???
//
//
//  private val value: UIO[Boolean] = ZIO.succeed(true)
//
//  IO.succeed(1)
//
//  RIO.succeed(2)
//
//  IO.fail(4)
//
//  new Exception()
//
//  new Throwable()
//
//  RIO.fail(new Exception("error...."))
//
//
//  private val fromOption: IO[Option[Nothing], Int] = ZIO.fromOption(Some(3))
//
//  private val errorFromOption: ZIO[Any, String, Int] = fromOption.mapError(_ => "error...")
//
//
//  private val value1: IO[Nothing, String] = ZIO.fromEither(Right("1"))
//
//  // 同步副作用：如果会抛出异常 attempt,  确定不会抛出异常时可以用 succeed
//  private val function:  IO[IOException, String]  = ZIO.attempt(StdIn.readLine()).refineOrDie[IOException]
//
//  // 异步
//
//  // 产出阻塞的同步副作用。
//// 为防止线程池被消耗完，zio另区别对待。
//
//
//  // map
//  // flatMap
//  // for表达式
//  // zip
//  private val value2: ZIO[Any, Nothing, Int] = ZIO.succeed(23).map(_ * 3)
//
//  ZIO.fail("error").mapError(msg => new Exception(msg))
//
//  private val value3: ZIO[Any, Nothing, (String, Int)] = ZIO.succeed("1").zip(ZIO.succeed(1))
//
//  val zipRight: ZIO[Has[Console], IOException, String] = printLine("hello") *> readLine
//
//
//
//
//}

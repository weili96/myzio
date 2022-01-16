package document.overview

//import zio.{Has, ZIO, ZIOAppArgs, ZIOAppDefault}

//object HandlngResources extends ZIOAppDefault{
//  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = ???
//
//
//  //ZIO provides similar functionality to try / finally with the ZIO#ensuring method.
//  ZIO.attempt(3).ensuring(ZIO.succeed("succeed"))
//
//
//  //afely acquiring and releasing resources, such as new socket connections or opened files:
//  //encapsulates this common pattern with ZIO#acquireRelease, which allows you to specify an acquire effect,
//  // which acquires a resource; a release effect, which releases it; and a use effect, which uses the resource.
//  ZIO.attempt(3)
//    .acquireRelease(ZIO.succeed("release"),ZIO.succeed("succeed"))
//
//}

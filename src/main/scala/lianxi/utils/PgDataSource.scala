package lianxi.utils

import com.typesafe.config.{Config, ConfigFactory}
import org.postgresql.ds.PGSimpleDataSource

import java.io.Closeable

object PgDataSource {


  //  val config = new HikariConfig()
  //  config.setDataSource(source)

  def getPublicSchemaSource = {
    val conf: Config = ConfigFactory.load
    val source = new PGSimpleDataSource() with Closeable {
      override def close(): Unit = super.getConnection.close()
    }
    source.setUser(conf.getString("ctx.dataSource.user"))
    source.setPassword(conf.getString("ctx.dataSource.password"))
    source.setDatabaseName(conf.getString("ctx.dataSource.databaseName"))
    source.setPortNumbers(Array(conf.getInt("ctx.dataSource.portNumber")))
    source.setServerNames(Array(conf.getString("ctx.dataSource.serverName")))
    source.setConnectTimeout(conf.getInt("ctx.connectionTimeout"))
    source.setCurrentSchema("public")
//    println(source.getCurrentSchema)
//    println(conf.getString("ctx.dataSource.user"))
    source
  }



}

package lianxi

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config
import io.getquill.{EntityQuery, ImplicitQuery, JdbcContextConfig, MirrorSqlDialect, PostgresDialect, PostgresJdbcContext, SnakeCase, SqlMirrorContext}
import org.postgresql.ds.PGSimpleDataSource
import zio._
import zio.console.putStrLn
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import lianxi.entity.Student
import lianxi.utils.PgDataSource
import zio.json.{DecoderOps, DeriveJsonDecoder, JsonDecoder}

import java.io.{Closeable, PrintWriter}
import java.text.{DateFormat, SimpleDateFormat}
import java.util.Date



/**
 * 浏览器输入用户信息，存入postgresql数据库中
 */

object UserApp extends App {



  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    result.exitCode
    insertStu.exitCode
  }


  // 获取连接数据库的资源
  val pgSource = PgDataSource.getPublicSchemaSource
  lazy val ctx = new PostgresJdbcContext(SnakeCase, pgSource)
  import ctx._

  val queryUser = ZIO.effect{
    val q = quote {
      query[Student]
    }
    println(q.toString())
    val value = ctx.run(q)
    value
  }

  val result = for {
    user <- queryUser
    _ <- putStrLn(user.toString())
  } yield ()

  // 把json格式的数据插入数据库
  val studentJson =
    """
      |{
      |    "id":3,
      |    "name":"hello0000",
      |    "dateOfBirth":"2021-11-12",
      |    "gender":"男"
      |}
      |""".stripMargin

//  implicit val decoder = DeriveJsonDecoder.gen[Student]

  val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")

  implicit val decoder = JsonDecoder[(Int,String,String,String)].map{
    case (id,name,dateOfBirth,gender) => {
      val date = simpleDateFormat.parse(dateOfBirth)
      Student(id,name,date,gender)
    }
  }

  val stuJson = """[4,"self","2021-11-12 10:12:10","女"]"""

  private val student: Either[String, Student] = stuJson.fromJson[Student]

  println(student)

//  SHORT：18-10-15 上午9:30
//  FULL：2018年10月15日 星期一 上午09时30分43秒 CST
//  MEDIUM：2018-10-15 9:30:43
//  LONG：2018年10月15日 上午09时30分43秒

  val insertDate = simpleDateFormat.parse("2021-11-12")


  val stu = student.getOrElse(Student(10,"default",insertDate,"男"))

  val insertStu = ZIO.effect{
    val q = quote{
      query[Student].insert(lift(stu))
    }
    ctx.run(q)
  }

}

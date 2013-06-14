package controllers

import play.api.mvc._
import java.io.File
import play.api.libs.iteratee.Enumerator
import play.api.libs.concurrent.Akka
import play.api.Play.current
import concurrent.ExecutionContext
import ExecutionContext.Implicits.global
import com.mongodb.casbah.Imports._



object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def musics(id: String) = Action {
    httpRequest =>
      val key = httpRequest.headers.get("authkey").getOrElse(Forbidden("meh..."))
      if (true) {
        val header = ResponseHeader(OK, Map("Content-Type" -> "video/MP2T"))
        val promiseOfFileContent = asycLoadFileContent(id)
        Async {
          promiseOfFileContent.map {
            content =>
              SimpleResult(header, content)
          }
        }
      } else {
        Forbidden
      }
  }

  private def asycLoadFileContent(id: String) = Akka.future {
    val file = new File("assets/%s".format(id))
    val fileContent: Enumerator[Array[Byte]] = Enumerator.fromFile(file)
    fileContent
  }

  def user = Action {
    val mongoClient = MongoClient("192.168.20.8")
    val builder = MongoDBObject.newBuilder
    builder += "name" -> "Sean Lee"
    builder += "phone" -> "082823333"
    builder += "name" -> "2322 Rowson St., CA"
    val obj = builder.result
    val users = mongoClient.getDB("users").getCollection("user")
    users.insert(obj)

    Ok(views.html.index("Hello"))
  }
}
package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

case class Message(text: String)

object ChatController extends Controller {

    val messageForm = Form(
      mapping(
        "text" -> text
      )(Message.apply)(Message.unapply)
    )
    var message = Seq("Hello", "This is", "Awesome")

    def index = Action { request =>
      Ok(views.html.index(message)) 
    }

    def postMessage = Action { request =>
      val populatedForm: Form[Message] = messageForm.bindFromRequest()(request)
      println(populatedForm)
      Ok(views.html.index(message)) 
    }

    def calc(a: String, b: String) = Action { request =>
      val ans = a + b
      Ok("the answer is " + ans)
    }

}

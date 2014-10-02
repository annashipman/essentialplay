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
    var messages = Seq("Hello", "This is", "Awesome")

    def index = Action { request =>
      Ok(views.html.index(messages)) 
    }

    def postMessage = Action { request =>
      val populatedForm: Form[Message] = messageForm.bindFromRequest()(request)

      populatedForm.fold(
        errors => {
          BadRequest("errors")
        },
        message => {
          messages = messages :+ message.text
          Ok(views.html.index(messages))
        }
      )
    }

    def calc(a: String, b: String) = Action { request =>
      val ans = a + b
      Ok("the answer is " + ans)
    }

}

package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

case class Message(name: String, text: String)

object ChatController extends Controller {

    val messageForm: Form[Message] = Form(
      mapping(
        "text" -> text,
        "name" -> text
      )(Message.apply)(Message.unapply)
    )
    var messages = Seq(
      Message("Anna", "Hello"),
      Message("Kush", "This is"),
      Message("Richard", "Awesome")
    )

    def index = Action { request =>
      Ok(views.html.index(messages, messageForm)) 
    }

    def postMessage = Action { request =>
      val populatedForm: Form[Message] = messageForm.bindFromRequest()(request)

      populatedForm.fold(
        (errors: Form[Message]) => {
          println("error")
          Ok(views.html.index(messages, errors))
        },
        message => {
          messages = messages :+ Message(message.name, message.text)
          Ok(views.html.index(messages, populatedForm))
        }
      )
    }

    def calc(a: String, b: String) = Action { request =>
      val ans = a + b
      Ok("the answer is " + ans)
    }

}

package controllers

import play.api.mvc._

object ChatController extends Controller {

    val message = Seq("Hello", "This is", "Awesome")

    def index = Action { request =>
      Ok(views.html.index()) 
    }

    def calc(a: String, b: String) = Action { request =>
      val ans = a + b
      Ok("the answer is " + ans)
    }

}

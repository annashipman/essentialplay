package controllers

import play.api.mvc._

object ChatController extends Controller {

    def index = Action { request =>
      Ok("hello world") //will construct a response with a 200
    }

    def calc(a: String, b: String) = Action { request =>
      val ans = a + b
      Ok("the answer is " + ans)
    }

}

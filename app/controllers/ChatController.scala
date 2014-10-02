package controllers

import play.api.mvc._

object ChatController extends Controller {

    //Place your actions here

    def index = Action { request =>
      Ok("hello world) //will construct a response with a 200
    }

}

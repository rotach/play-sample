package controllers

import play.api._
import play.api.mvc._
import models.Thing

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready.", Thing("Test thing", 10)))
  }
  
  def error = Action {
    controllers.Application.Status(403)
  }
  
}
package tests

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class ControllerTests extends Specification {

  "Controller Tests" should {
    /*
    "first name" in {
      "John Rotach" must contain("John")
    }
    "last name" in {
      "John Rotach" must contain("Rotach")
    }
    */
    
    "Index" in {
      val result = controllers.Application.index()(FakeRequest())
      status(result) must equalTo(OK)
      contentAsString(result) must contain("Test thing:10")
    }
    
    "Router Test (/)" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("Test thing:10")      
    }
    
    "Router Test (/error)" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/error"))
      status(result) must equalTo(403)   
    }
  }
}
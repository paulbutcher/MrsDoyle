package com.paulbutcher.mrsdoyle

import org.scalatest.{WordSpec, BeforeAndAfterEach}
import org.scalamock.generated.GeneratedMockFactory
import org.scalamock.scalatest.MockFactory
import org.scalamock.{CallLogging, VerboseErrors}

import StateMachine._

class StateMachineTest extends WordSpec with BeforeAndAfterEach with MockFactory with GeneratedMockFactory {
  
  val ted = Drinker("ted")
  val dougal = Drinker("dougal")
  val jack = Drinker("jack")

  "The state machine" when {

    "in state normal" should {

      "complain when it doesn't understand" in {
        //! TODO
      }
      
      "start making tea when asked to" in {
        //! TODO
      }
    }
    
    "in state making tea" should {
      
      "respond to a drinker saying yes" in {
        //! TODO
      }
      
      "select someone at random when time runs out" in {
        //! TODO
      }
    }
  }
  
  override def beforeEach {
  }
}

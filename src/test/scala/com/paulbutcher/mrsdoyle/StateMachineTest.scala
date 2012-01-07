package com.paulbutcher.mrsdoyle

import org.scalatest.{WordSpec, BeforeAndAfterEach}
import org.scalamock.generated.GeneratedMockFactory
import org.scalamock.scalatest.MockFactory
import org.scalamock.{CallLogging, VerboseErrors}

import StateMachine._

class StateMachineTest extends WordSpec with BeforeAndAfterEach with MockFactory with GeneratedMockFactory with VerboseErrors with CallLogging {
  
  val ted = Drinker("ted")
  val dougal = Drinker("dougal")
  val jack = Drinker("jack")

  "The state machine" when {

    "in state normal" should {

      "complain when it doesn't understand" in {
        state = stateNormal

        val messaging = mockObject(Messaging)
        messaging.expects.send(ted, "Sorry, I didn't understand that")
        
        handle(IncomingMessage(ted, "The slithey toves did gyre, etc"))
        
        assert(state === stateNormal)
      }
      
      "start making tea when asked to" in {
        state = stateNormal

        val messaging = mockObject(Messaging)
        val drinkers = mockObject(Drinkers)

        drinkers.expects.setWantsTea(ted)
        drinkers.expects.allBut(ted) returning Seq(dougal, jack)
        messaging.expects.send(ted, "What a great idea")
        messaging.expects.send(Seq(dougal, jack), "Would you like to join us?")
        
        handle(IncomingMessage(ted, "Fancy a cuppa?"))
        
        assert(state === stateMakingTea)
      }
    }
    
    "in state making tea" should {
      
      "respond to a drinker saying yes" in {
        state = stateMakingTea
        
        val messaging = mockObject(Messaging)
        val drinkers = mockObject(Drinkers)

        drinkers.expects.setWantsTea(dougal)
        messaging.expects.send(dougal, "That's great news")
        
        handle(IncomingMessage(dougal, "Oh, yes please"))
        
        assert(state === stateMakingTea)
      }
    }
  }
  
  override def beforeEach {
    val utterances = mockObject(Utterances)

    utterances.expects.whatDidYouSay returning "Sorry, I didn't understand that" anyNumberOfTimes;
    utterances.expects.goodIdea returning "What a great idea" anyNumberOfTimes;
    utterances.expects.invitation returning "Would you like to join us?" anyNumberOfTimes;
    utterances.expects.greatNews returning "That's great news" anyNumberOfTimes;
  }
}

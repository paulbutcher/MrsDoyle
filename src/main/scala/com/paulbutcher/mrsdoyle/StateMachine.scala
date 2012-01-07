package com.paulbutcher.mrsdoyle

import Utterances._

object StateMachine {

  type Handler = PartialFunction[Event, Unit]
  
  def handle = state orElse dontUnderstand
  
  val stateNormal: Handler = {
    case IncomingMessage(from, body) if wantsTea(body) =>
      from.wantsTea
      XMPPMessaging.send(from, goodIdea)
      XMPPMessaging.send(Drinkers.allBut(from), invitation)
      state = stateMakingTea
  }
  
  val stateMakingTea: Handler = {
    case IncomingMessage(from, body) if saysYes(body) =>
      from.wantsTea
      XMPPMessaging.send(from, greatNews)
      
    case MakeTea =>
      val maker = Drinkers.chooseMaker
      XMPPMessaging.send(maker, youreIt)
      XMPPMessaging.send(Drinkers.allBut(maker), willMake)
      Drinkers.resetWantsTea()
  }
  
  val dontUnderstand: Handler = {
    case IncomingMessage(from, _) =>
      XMPPMessaging.send(from, whatDidYouSay)
    case _ =>
  }
  
  var state: Handler = stateNormal
}
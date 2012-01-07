package com.paulbutcher.mrsdoyle

import Utterances._

object StateMachine {

  type Handler = PartialFunction[IncomingMessage, Unit]
  
  def handle = state orElse dontUnderstand
  
  val stateNormal: Handler = {
    case IncomingMessage(from, body) if wantsTea(body) =>
      XMPPMessaging.send(from, goodIdea)
      XMPPMessaging.send(Drinkers.get, invitation)
      state = stateMakingTea
  }
  
  val stateMakingTea: Handler = {
    case IncomingMessage(from, body) =>
    
  }
  
  val dontUnderstand: Handler = {
    case IncomingMessage(from, _) =>
      XMPPMessaging.send(from, whatDidYouSay)
  }
  
  var state: Handler = stateNormal
}
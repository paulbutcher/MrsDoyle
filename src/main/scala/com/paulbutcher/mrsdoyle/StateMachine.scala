package com.paulbutcher.mrsdoyle

import Utterances._

object StateMachine {

  type Handler = PartialFunction[IncomingMessage, Unit]
  
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
  }
  
  val dontUnderstand: Handler = {
    case IncomingMessage(from, _) =>
      XMPPMessaging.send(from, whatDidYouSay)
  }
  
  var state: Handler = stateNormal
}
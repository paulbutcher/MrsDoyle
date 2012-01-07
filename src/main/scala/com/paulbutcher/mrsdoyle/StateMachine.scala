package com.paulbutcher.mrsdoyle

import Utterances._

object StateMachine {

  type Handler = PartialFunction[Event, Unit]
  
  def handle = state orElse dontUnderstand
  
  val stateNormal: Handler = {
    case IncomingMessage(from, body) if wantsTea(body) =>
      from.wantsTea
      Deferred.makeTeaIn(120)
      Messaging.send(from, goodIdea)
      Messaging.send(Drinkers.allBut(from), invitation)
      state = stateMakingTea
  }
  
  val stateMakingTea: Handler = {
    case IncomingMessage(from, body) if saysYes(body) =>
      from.wantsTea
      Messaging.send(from, greatNews)
      
    case MakeTea =>
      val maker = Drinkers.chooseMaker
      Messaging.send(maker, youreIt)
      Messaging.send(Drinkers.allBut(maker), willMake)
      Drinkers.resetWantsTea()
      state = stateNormal
  }
  
  val dontUnderstand: Handler = {
    case IncomingMessage(from, _) =>
      Messaging.send(from, whatDidYouSay)
    case _ =>
  }
  
  var state: Handler = stateNormal
}
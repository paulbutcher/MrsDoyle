package com.paulbutcher.mrsdoyle

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class IncomingMessageServlet extends HttpServlet {

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    StateMachine.handle(IncomingMessage(req))
  }
}

object StateMachine {

  type Handler = PartialFunction[IncomingMessage, Unit]
  
  def handle = state orElse dontUnderstand
  
  val stateNormal: Handler = {
    case IncomingMessage(from, body) if wantsTea(body) =>
      XMPPMessaging.send(from, goodIdea.choose)
      XMPPMessaging.send(Drinkers.get, invitation.choose)
      state = stateMakingTea
  }
  
  val stateMakingTea: Handler = {
    case IncomingMessage(from, body) =>
    
  }
  
  val dontUnderstand: Handler = {
    case IncomingMessage(from, _) =>
      XMPPMessaging.send(from, whatDidYouSay.choose)
  }
  
  var state: Handler = stateNormal
}
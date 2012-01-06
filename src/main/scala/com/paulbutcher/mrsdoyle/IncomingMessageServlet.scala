package com.paulbutcher.mrsdoyle

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class IncomingMessageServlet extends HttpServlet {

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    handle(IncomingMessage(req))
  }
  
  def handle(m: IncomingMessage) {
    m match {
      case IncomingMessage(from, body) =>
        XMPPMessaging.send(Drinkers.get, invitation.choose)
    }
  }
}

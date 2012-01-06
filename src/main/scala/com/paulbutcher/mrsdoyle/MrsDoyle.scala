package com.paulbutcher.mrsdoyle

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class MrsDoyle extends HttpServlet {

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    handle(IncomingMessage(req))
  }
  
  def handle(m: IncomingMessage) {
    m match {
      case IncomingMessage(from, body) =>
        Messaging.send(Drinkers.get, invitation.choose)
    }
  }
}

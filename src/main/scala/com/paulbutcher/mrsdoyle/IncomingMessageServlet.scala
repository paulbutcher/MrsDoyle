package com.paulbutcher.mrsdoyle

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class IncomingMessageServlet extends HttpServlet {

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    StateMachine.handle(IncomingMessage(req))
  }
}

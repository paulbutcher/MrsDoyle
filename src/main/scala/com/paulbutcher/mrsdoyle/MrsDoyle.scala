package com.paulbutcher.mrsdoyle

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class MrsDoyle extends HttpServlet {

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    Messaging.handle(req) { (from, body) => 
      Messaging.send(from, "You said: "+ body)
    }
  }
}

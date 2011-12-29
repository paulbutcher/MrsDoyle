package com.paulbutcher

import com.google.appengine.api.xmpp.{MessageBuilder, XMPPServiceFactory}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class HelloXmpp extends HttpServlet {

  val xmppService = XMPPServiceFactory.getXMPPService

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    val message = xmppService.parseMessage(req)
    val fromId = message.getFromJid
    val presence = xmppService.getPresence(fromId)
    val presenceString = if (presence.isAvailable) "" else "not "
    xmppService.sendMessage(new MessageBuilder().
      withBody(message.getBody + " (you are " + presenceString + "available)").
      withRecipientJids(fromId).
      build)
  }
}

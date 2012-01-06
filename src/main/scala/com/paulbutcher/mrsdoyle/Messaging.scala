package com.paulbutcher.mrsdoyle

import com.google.appengine.api.xmpp.{JID, MessageBuilder, XMPPServiceFactory}
import javax.servlet.http.HttpServletRequest

object Messaging {

  def handle(req: HttpServletRequest)(handler: (JID, String) => Unit) {
    val m = XMPP.service.parseMessage(req)
    handler(m.getFromJid, m.getBody)
  }
  
  def send(to: JID, body: String) {
    send(Seq(to), body)
  }
  
  def send(to: Seq[JID], body: String) {
    XMPP.service.sendMessage(
      new MessageBuilder().withBody(body).withRecipientJids(to: _*).build)
  }
}

object XMPP {
  lazy val service = XMPPServiceFactory.getXMPPService 
}
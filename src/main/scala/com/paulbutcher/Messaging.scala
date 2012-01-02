package com.paulbutcher

import com.google.appengine.api.xmpp.{JID, MessageBuilder, XMPPServiceFactory}
import javax.servlet.http.HttpServletRequest

object Messaging {

  val xmppService = XMPPServiceFactory.getXMPPService

  def handle(req: HttpServletRequest)(handler: (JID, String) => Unit) {
    val m = xmppService.parseMessage(req)
    handler(m.getFromJid, m.getBody)
  }
  
  def send(to: JID, body: String) {
    send(Seq(to), body)
  }
  
  def send(to: Seq[JID], body: String) {
    xmppService.sendMessage(new MessageBuilder().withBody(body).withRecipientJids(to: _*).build)
  }
}
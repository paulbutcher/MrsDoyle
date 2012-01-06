package com.paulbutcher.mrsdoyle

import com.google.appengine.api.xmpp.{JID, MessageBuilder, XMPPServiceFactory}
import javax.servlet.http.HttpServletRequest

object Messaging {

  def handle(req: HttpServletRequest)(handler: (Drinker, String) => Unit) {
    val m = XMPP.service.parseMessage(req)
    val from = m.getFromJid
    Drinkers.add(from.toString)
    handler(Drinker(from.toString), m.getBody)
  }
  
  def send(to: Drinker, body: String) {
    send(Seq(to), body)
  }
  
  def send(to: Seq[Drinker], body: String) {
    val ids = to map (d => new JID(d.id))
    XMPP.service.sendMessage(
      new MessageBuilder().withBody(body).withRecipientJids(ids: _*).build)
  }
}

object XMPP {
  lazy val service = XMPPServiceFactory.getXMPPService 
}
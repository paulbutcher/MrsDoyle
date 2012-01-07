package com.paulbutcher.mrsdoyle

import com.google.appengine.api.xmpp.{JID, MessageBuilder}

object Messaging {
  
  def send(to: Iterable[Drinker], body: String) {
    val ids = to map (d => new JID(d.id))
    XMPP.service.sendMessage(
      new MessageBuilder().withBody(body).withRecipientJids(ids.toSeq: _*).build)
  }
  
  def send(to: Drinker, body: String) {
    send(Iterable(to), body)
  }
}

package com.paulbutcher.mrsdoyle

import javax.servlet.http.HttpServletRequest

case class IncomingMessage private(from: Drinker, body: String)

object IncomingMessage {
  
  def apply(req: HttpServletRequest) = {
    val m = XMPP.service.parseMessage(req) 
    val from = m.getFromJid
    val d = Drinkers.add(from.getId)
    new IncomingMessage(d, m.getBody)
  }
}
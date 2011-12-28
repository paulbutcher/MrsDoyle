package com.paulbutcher

import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.MessageType;
import com.google.appengine.api.xmpp.Presence;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloXmpp is an echo bot that sends back the message it receives.
 */
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

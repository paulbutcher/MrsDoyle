package com.paulbutcher;

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
public class HelloXmpp extends HttpServlet {

  private XMPPService xmppService;

  @Override
  public void init() {
    this.xmppService = XMPPServiceFactory.getXMPPService();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException {
    processMessage(xmppService.parseMessage(req), res);
  }

  public void processMessage(Message message, HttpServletResponse res) throws IOException {
    JID fromId = message.getFromJid();
    Presence presence = xmppService.getPresence(fromId);
    String presenceString = presence.isAvailable() ? "" : "not ";
    SendResponse response = xmppService.sendMessage(
        new MessageBuilder().
        withBody(message.getBody() + " (you appear to be " + presenceString + "available)").
        withRecipientJids(fromId).
        build());
  }
}

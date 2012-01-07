package com.paulbutcher.mrsdoyle

import org.scalamock.annotation.{mock, mockObject}

import com.google.appengine.api.xmpp.{Message, MessageBuilder, XMPPService}
 
@mock[MessageBuilder]
@mock[Message]
@mock[XMPPService]
@mockObject(XMPPMessaging)
@mockObject(XMPP)
@mockObject(Utterances)
@mockObject(Drinkers)
class Dummy
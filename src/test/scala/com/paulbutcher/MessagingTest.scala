package com.paulbutcher

import org.scalatest.FunSuite
import org.scalamock.generated.GeneratedMockFactory
import org.scalamock.scalatest.MockFactory
import org.scalamock.{CallLogging, VerboseErrors}

import com.google.appengine.api.xmpp.{JID, Message, MessageBuilder, XMPPService}

class MessagingTest extends FunSuite with MockFactory with GeneratedMockFactory with VerboseErrors with CallLogging {

  test("send") {
    val x = mockObject(XMPP)
    val s = mock[XMPPService]
    val b = mock[MessageBuilder]
    val m = mock[Message]
    val to = new JID("id1")
    
    x.expects.service returning s
    inSequence {
      b.expects.newInstance
      inAnyOrder {
        b.expects.withBody("a test message") returning b
        b.expects.withRecipientJids(to) returning b
      }
      b.expects.build returning m
      s.expects.sendMessage(m)
    }
    
    Messaging.send(to, "a test message")
  }
}
package com.paulbutcher.mrsdoyle

import org.scalatest.FunSuite
import org.scalamock.generated.GeneratedMockFactory
import org.scalamock.scalatest.MockFactory
import org.scalamock.{CallLogging, VerboseErrors}

import com.google.appengine.api.xmpp.{JID, Message, MessageBuilder, XMPPService}

class MessagingTest extends FunSuite with MockFactory with GeneratedMockFactory {

  test("send") {
    //! TODO
  }
}
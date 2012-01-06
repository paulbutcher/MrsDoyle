package com.paulbutcher.mrsdoyle

import com.google.appengine.api.xmpp.XMPPServiceFactory

object XMPP {

  lazy val service = XMPPServiceFactory.getXMPPService 
}
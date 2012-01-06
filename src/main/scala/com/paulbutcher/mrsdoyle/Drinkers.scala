package com.paulbutcher.mrsdoyle

import scala.collection.JavaConverters._

import com.google.appengine.api.datastore.{DatastoreServiceFactory, Entity, FetchOptions, KeyFactory, Query}
import com.google.appengine.api.xmpp.JID
import FetchOptions.Builder._

case class Drinker(id: JID)

object Drinkers {

  def add(id: JID) {
    val d = new Entity("Drinker", key)
    d.setProperty("id", id)
    store.put(d)
  }
  
  def get: Seq[Drinker] = {
    val q = new Query("Drinkers", key)
    val ds = store.prepare(q).asList(withLimit(99)).asScala
    ds map { d => Drinker(d.getProperty("id").asInstanceOf[JID]) }
  }
  
  lazy val key = KeyFactory.createKey("Drinker", "Drinkers")
  lazy val store = DatastoreServiceFactory.getDatastoreService
}
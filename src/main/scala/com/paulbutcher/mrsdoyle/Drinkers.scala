package com.paulbutcher.mrsdoyle

case class Drinker(id: String)

object Drinkers {

  def add(id: String) {
    drinkers.add(Drinker(id))
  }
  
  def get: Iterable[Drinker] = drinkers

  // Quick and dirty in-process implementation. Will break horribly if more than
  // one instance is running
  lazy val drinkers = collection.mutable.Set[Drinker]()
}
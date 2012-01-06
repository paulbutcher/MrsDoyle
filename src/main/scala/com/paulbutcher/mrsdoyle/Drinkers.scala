package com.paulbutcher.mrsdoyle

case class Drinker(id: String)

object Drinkers {

  def add(id: String): Drinker = {
    val d = Drinker(id)
    drinkers.add(d)
    d
  }
  
  def get: Iterable[Drinker] = drinkers

  // Quick and dirty in-process implementation. Will break horribly if more than
  // one instance is running
  lazy val drinkers = collection.mutable.Set[Drinker]()
}
package com.paulbutcher.mrsdoyle

case class Drinker(id: String) {
  def wantsTea() {
    Drinkers.setWantsTea(this)
  }
}

object Drinkers {

  def add(id: String): Drinker = {
    val d = Drinker(id)
    drinkers.add(d)
    d
  }
  
  def allBut(exclude: Drinker): Iterable[Drinker] =
    drinkers filter (d => d.id != exclude)
  
  def setWantsTea(d: Drinker) {
    drinkers += d
  }

  lazy val drinkers = collection.mutable.Set[Drinker]()
  lazy val wantsTea = collection.mutable.Set[Drinker]()
}
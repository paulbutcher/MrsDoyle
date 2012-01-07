package com.paulbutcher.mrsdoyle

import scala.util.Random

object Utils {

  def pickRandom[T](options: IndexedSeq[T]): T = options(Random.nextInt(options.length))
  
  def pickRandom[T](options: T*): T = pickRandom(options.toIndexedSeq)
}
package com.paulbutcher.mrsdoyle

import org.scalatest.{BeforeAndAfterEach, FunSuite}

import Drinkers._

class DrinkersTest extends FunSuite with BeforeAndAfterEach {

  test("allBut") {
    drinkers ++= Seq(Drinker("ted"), Drinker("dougal"), Drinker("jack"))
    expect(Set(Drinker("ted"), Drinker("jack"))) { allBut(Drinker("dougal")) }
  }
  
  override def afterEach {
    drinkers.clear
  }
}
package com.paulbutcher.mrsdoyle

import scala.util.matching.Regex

trait Parser {
  
  val pattern: Regex
  
  def apply(s: String) = (pattern findFirstMatchIn s).isDefined
}

object wantsTea extends Parser {

  val pattern = """(?i)cuppa|tea|brew|cup|drink|beverage|refreshment""".r
}
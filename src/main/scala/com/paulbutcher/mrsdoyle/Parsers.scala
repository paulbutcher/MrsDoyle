package com.paulbutcher.mrsdoyle

import scala.util.matching.Regex

trait Parser {
  
  val pattern: Regex
  
  def apply(s: String) = (pattern findFirstMatchIn s).isDefined
}

object wantsTea extends Parser {

  val pattern = """(?i)cuppa|tea|brew|cup|drink|beverage|refreshment""".r
}

object saysYes extends Parser {
  
  val pattern = """(?i)yes|yeh|ya|booyah|ok|please|totally|definitely|absolutely|yeah|yup|affirmative|yarr|yah|please|sure|okay|alright|yep|go on|certainly""".r
}
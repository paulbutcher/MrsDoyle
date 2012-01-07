package com.paulbutcher.mrsdoyle

import org.scalatest.FunSuite

class ParsersTest extends FunSuite {

  test("wantsTea") {
    assert(wantsTea("Do you fancy a cuppa?"))
    assert(wantsTea("Will you have a brew?"))
    assert(wantsTea("Tea time, I think"))
    
    assert(!wantsTea("The quick brown fox, etc."))
    assert(!wantsTea("Would you like a coffee?"))
  }
}
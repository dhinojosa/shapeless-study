package com.xyzcorp

import org.scalatest.{FunSpec, Matchers}
import shapeless.Nat

class NatSpec extends FunSpec with Matchers {
   describe("""Nat is a type level encoding of a natural number""") {
       val nat = Nat(30)
       nat
   }
}

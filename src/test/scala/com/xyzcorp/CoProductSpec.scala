package com.xyzcorp

import org.scalatest.{FunSpec, Matchers}
import shapeless.ops.coproduct
import shapeless.ops.coproduct.Mapper
import shapeless.{:+:, CNil, Inl, Poly1}

class CoProductSpec extends FunSpec with Matchers {
  describe("""A coproduct is a type that can be either of the
         |  type or like an or-relationship of types.""".stripMargin) {
    it("""has a type declaration that has :+:, which has two subtypes,
           |  Inl or Inr, read as Inl or Inr.""".stripMargin) {

      type MyEither = String :+: Int :+: CNil
      val e: MyEither = Inl("SomeString")

      object MyPoly1 extends Poly1 {
        implicit val stringCase: Case.Aux[String, Int] = at(_.length)
        implicit val intCase: Case.Aux[Int, Int] = at(_ + 10)
      }

      val value1: Int :+: Int :+: CNil = e.map(MyPoly1)
      value1
    }
  }
}

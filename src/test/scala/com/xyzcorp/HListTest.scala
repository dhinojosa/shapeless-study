package com.xyzcorp

import org.scalatest.{FunSpec, Matchers}
import shapeless.HNil

class HListTest extends FunSpec with Matchers {

   describe("""An HList is an heterogeneous list, which is a list with varying types""") {
     it(
       """requires an import :: which overrides the scala.List implementation, HNil
         |  represents the empty heterogeneous list""".stripMargin) {
       case class User(name: String)

       val list = 42 :: "Hello" :: User("Danno") :: HNil
     }
   }
}

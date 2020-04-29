package com.xyzcorp

import org.scalatest.{FunSpec, Matchers}
import shapeless.{Generic, HNil}

class HListSpec extends FunSpec with Matchers {

  describe(
    """An HList is an heterogeneous list, which is a list with varying types"""
  ) {
    it("""requires an import :: which overrides the
         |  scala.List implementation, HNil
         |  represents the empty heterogeneous list""".stripMargin) {
      case class User(name: String)
      42 :: "Hello" :: User("Danno") :: HNil
    }

    it("""has the ability to maintain the type when placed
          |  into the collection""".stripMargin) {
      case class User(name: String)
      val list = 42 :: "Hello" :: User("Danno") :: HNil
      val head: Int = list.head
      head.getClass.getSimpleName should be ("int") //workaround
    }

    it("""can be converted to any Traversable as long as it
          |  has a collection to convert it to.  Be aware
          |  that since the list is heterogeneous, the list
          |  might be of a type Any.""".stripMargin) {
      case class User(name: String)
      val list = 42 :: "Hello" :: User("Danno") :: HNil
      val scalaList: List[Any] = list.to[List]
      scalaList shouldBe a[List[Any]]
    }
  }
}

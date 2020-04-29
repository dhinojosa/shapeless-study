package com.xyzcorp

import org.scalatest.{FunSpec, Matchers}
import shapeless.{Generic, HNil}

class GenericSpec extends FunSpec with Matchers {
  describe("""Generic is a type class that allows us to
         |   convert between the case class and generic representation
         |   like an HList and an ADT or case class""".stripMargin) {

    it("""uses `to` to convert from an HList to an object""") {
      case class Team(name: String, city: String, wins: Int, losses: Int)
      val items = "Seahawks" :: "Seattle" :: 3 :: 2 :: HNil
      val genTeam = Generic[Team]
      val team1 = genTeam.from(items)
      team1.name should be("Seahawks")
    }

    it("""uses `from` to convert from an object to HList""") {
      case class Team(name: String, city: String, wins: Int, losses: Int)
      val team = Team("Seahawks", "Seattle", 3, 2)
      val genTeam = Generic[Team]
      val gen = genTeam.to(team)
      gen should be("Seahawks" :: "Seattle" :: 3 :: 2 :: HNil)
    }
  }
}

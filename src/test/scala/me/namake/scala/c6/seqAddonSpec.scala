package me.namake.scala.c6

import org.scalatest.{FunSpec, Matchers}

class seqAddonSpec extends FunSpec with Matchers {
  describe("minOption()") {
    it("returns the smallest integer") {
      seqAddon.minOption(Seq(3, 2, 9)) shouldBe Some(2)
      seqAddon.minOption(Seq(1)) shouldBe Some(1)
      seqAddon.minOption(Seq()) shouldBe None
    }
  }

  describe("min()") {
    it("returns the smallest integer") {
      seqAddon.min(Seq(4, 2, 9)) shouldBe 2
      seqAddon.min(Seq(5)) shouldBe 5
    }

    it("returns max integer when collection is empty") {
      seqAddon.min(Seq()) shouldBe Int.MaxValue
    }
  }
}

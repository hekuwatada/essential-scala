package me.namake.scala.c6

import org.scalatest.{FunSpec, Matchers}

class seqAddonSpec extends FunSpec with Matchers {
  describe("min()") {
    it("returns the smallest integer") {
      seqAddon.min(Seq(3, 2, 9)) shouldBe Some(2)
      seqAddon.min(Seq(1)) shouldBe Some(1)
      seqAddon.min(Seq()) shouldBe None
    }
  }
}

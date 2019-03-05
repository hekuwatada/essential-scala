package me.namake.scala

import org.scalatest.{FunSpec, Matchers}

class IntListSpec extends FunSpec with Matchers {

  describe("sum") {
    it("returns sum") {
      End.sum shouldBe 0
      Pair(1, Pair(2, Pair(3, End))).sum shouldBe 6
    }
  }

  describe("product") {
    it("returns product") {
      End.product shouldBe 1
      Pair(3, Pair(2, Pair(5, End))).product shouldBe 30
    }
  }
}

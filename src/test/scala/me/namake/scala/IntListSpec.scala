package me.namake.scala

import org.scalatest.{FunSpec, Matchers}

class IntListSpec extends FunSpec with Matchers {

  describe("sum") {
    it("returns sum") {
      End.sum shouldBe 0
      Pair(1, Pair(2, Pair(3, End))).sum shouldBe 6
    }
  }

  describe("length") {
    it("returns length of list") {
      End.length shouldBe 0
      Pair(1, End).length shouldBe 1
      Pair(1, Pair(2, Pair(3, Pair(4, End)))).length shouldBe 4
    }
  }

  describe("product") {
    it("returns product") {
      End.product shouldBe 1
      Pair(3, Pair(2, Pair(5, End))).product shouldBe 30
    }
  }

  describe("double") {
    it("doubles elements") {
      End.double shouldBe End
      Pair(1, End).double shouldBe Pair(2, End)
      Pair(3, Pair(2, Pair(5, End))).double shouldBe Pair(6, Pair(4, Pair(10, End)))
    }
  }
}

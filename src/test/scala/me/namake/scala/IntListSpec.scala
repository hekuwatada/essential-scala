package me.namake.scala

import org.scalatest.{FunSpec, Matchers}

class IntListSpec extends FunSpec with Matchers {

  describe("sum") {
    it("returns sum") {
      IntListEnd.sum shouldBe 0
      IntListPair(1, IntListPair(2, IntListPair(3, IntListEnd))).sum shouldBe 6
    }
  }

  describe("length") {
    it("returns length of list") {
      IntListEnd.length shouldBe 0
      IntListPair(1, IntListEnd).length shouldBe 1
      IntListPair(1, IntListPair(2, IntListPair(3, IntListPair(4, IntListEnd)))).length shouldBe 4
    }
  }

  describe("product") {
    it("returns product") {
      IntListEnd.product shouldBe 1
      IntListPair(3, IntListPair(2, IntListPair(5, IntListEnd))).product shouldBe 30
    }
  }

  describe("double") {
    it("doubles elements") {
      IntListEnd.double shouldBe IntListEnd
      IntListPair(1, IntListEnd).double shouldBe IntListPair(2, IntListEnd)
      IntListPair(3, IntListPair(2, IntListPair(5, IntListEnd))).double shouldBe IntListPair(6, IntListPair(4, IntListPair(10, IntListEnd)))
    }
  }
}

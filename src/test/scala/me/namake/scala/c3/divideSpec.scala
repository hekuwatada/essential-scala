package me.namake.scala.c3

import org.scalatest.Matchers

class divideSpec extends org.scalatest.FunSpec with Matchers {

  describe("divide") {
    it("returns resulting integer division") {
      divide(1, 2) shouldBe Finite(0)
    }

    it("returns no result for zero division") {
      divide(1, 0) shouldBe Infinite
    }
  }
}

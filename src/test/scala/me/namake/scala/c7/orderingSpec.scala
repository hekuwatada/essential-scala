package me.namake.scala.c7

import org.scalatest.{FunSpec, Matchers}

class orderingSpec extends FunSpec with Matchers {

  describe("implicit ordering") {
    it("orders integers from lowest to highest by absolute value") {
      List(-4, -1, 0, 2, 3).sorted(ordering.absOrdering) shouldBe List(0, -1, 2, 3, -4)
      List(-4, -3, -2, -1).sorted(ordering.absOrdering) shouldBe List(-1, -2, -3, -4)
    }
  }
}

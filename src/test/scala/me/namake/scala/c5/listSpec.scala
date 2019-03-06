package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class listSpec extends FunSpec with Matchers {

  describe("sequencing computations") {
    it("addNegative() returns all elements and their negation") {
      list.addNegative(List()) shouldBe List()
      list.addNegative(List(1)) shouldBe List(1, -1)
      list.addNegative(List(1, 2, 3)) should contain theSameElementsAs List(1, 2, 3, -1, -2, -3)
    }

    it("removeOdd() replaces odd elements with None") {
      list.removeOdd(List()) shouldBe List()
      list.removeOdd(List(Full(3))) shouldBe List(Empty[Int]())
      list.removeOdd(List(Full(2))) shouldBe List(Full(2))
      list.removeOdd(List(Full(3), Full(2))) shouldBe List(Empty[Int](), Full(2))
      list.removeOdd(List(Full(3), Full(2), Full(1))) should contain theSameElementsAs
        List(Empty[Int](), Full(2), Empty[Int]())
    }
  }
}

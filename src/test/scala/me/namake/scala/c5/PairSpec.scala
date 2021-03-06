package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class PairSpec extends FunSpec with Matchers {

  describe("product type data structure") {
    it("can hold two different types") {
      val pair = Pair("one", 2)
      pair.one shouldBe "one"
      pair.two shouldBe 2
    }

  }
}

package me.namake.scala.c7

import org.scalatest.{FunSpec, Matchers}

class RationalSpec extends FunSpec with Matchers {

  describe("ordering") {
    it("orders from smallest to largest") {
      List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted shouldBe
        List(Rational(1, 3), Rational(1, 2), Rational(3, 4))
    }
  }
}

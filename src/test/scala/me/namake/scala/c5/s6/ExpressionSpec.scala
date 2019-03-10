package me.namake.scala.c5.s6

import org.scalatest.{FunSpec, Matchers}
import me.namake.scala.c5._

class ExpressionSpec extends FunSpec with Matchers {

  describe("eval") {
    it("evaluates expressions") {
      Addition(Number(1), Number(2)).eval shouldBe Right(3.0)
      SquareRoot(Number(-1)).eval shouldBe Left("Square root of negative number")
      SquareRoot(Number(9)).eval shouldBe Right(3.0)
      Division(Number(4), Number(0)).eval shouldBe Left("Division by zero")
      Division(Addition(Subtraction(Number(8), Number(6)), Number(2)), Number(2)).eval shouldBe Right(2.0)
    }

    it("returns left failure") {
      Division(SquareRoot(Number(-1)), Number(0)).eval shouldBe Left("Square root of negative number")
    }
  }
}

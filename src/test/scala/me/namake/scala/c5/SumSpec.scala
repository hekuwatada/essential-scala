package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class SumSpec extends FunSpec with Matchers {

  describe("sum type data structure") {
    it("has one of two possibly different types") {
      Left(1).value shouldBe 1
      Right("foo").value shouldBe "foo"
    }
  }

  describe("fold") {
    it("transforms A or B to C") {
      Left[Int, Boolean](3).fold(_.toString, _.toString) shouldBe "3"
      Right[Int, Boolean](false).fold(_.toString, _.toString) shouldBe "false"
    }
  }

  describe("map") {
    it("transforms Sum[A, B] to Sum[A, C]") {
      Right(false).map(x => if (x) 1 else 0) shouldBe Right(0)
      Left("left").map((_: Int).toString) shouldBe Left("left")
    }
  }

  describe("flatMap") {
    it("transforms Sum[A, B] to Sum[A, C]") {
      Right[Int, Boolean](false).flatMap(x => if (x) Right(1) else Right(0)) shouldBe Right(0)
      Left("left").flatMap((x: Int) => Right(x.toString)) shouldBe Left("left")
    }
  }
}

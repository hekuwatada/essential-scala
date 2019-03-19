package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class SumSpec extends FunSpec with Matchers {

  describe("sum type data structure") {
    it("has one of two possibly different types") {
      Left(1).value shouldBe 1
      Right("foo").value shouldBe "foo"
    }

    it("has covariant types for right and left") {
      val left: Sum[String, Double] = Left("error")
      val right: Sum[String, Double] = Right(2.0)
      Seq(left, right) shouldBe a[Seq[Sum[String, Double]]] //TODO: fix compiler warning
    }
  }

  describe("fold") {
    it("transforms A or B to C") {
      Left(3).fold(_.toString, identity) shouldBe "3"
      Right(false).fold(identity, _.toString) shouldBe "false"
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
      Right(false).flatMap((x: Boolean) => if (x) Right(1) else Right(0)) shouldBe Right(0)
      Left("left").flatMap(identity) shouldBe Left("left")
    }
  }
}

package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class SumSpec extends FunSpec with Matchers {

  describe("sum type data structure") {
    it("has one of two possibly different types") {
      Left[Int, String](1).value shouldBe 1
      Right[Int, String]("foo").value shouldBe "foo"
    }
  }

  describe("fold") {
    it("transforms A or B to C") {
      Left[Int, Boolean](3).fold(_.toString, _.toString) shouldBe "3"
      Right[Int, Boolean](false).fold(_.toString, _.toString) shouldBe "false"
    }
  }

  describe("map") {
    it("transforms Sum[A, B] to Sum[C, D]") {
      Left[Int, Boolean](3).map(_ + 1, _.toString) shouldBe Left[Int, String](4)
      Right[Int, Boolean](false).map(_.toString, x => if(x) 1 else 0) shouldBe Right[Int, Int](0)
    }
  }
}

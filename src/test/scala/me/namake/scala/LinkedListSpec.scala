package me.namake.scala

import org.scalatest.{FunSpec, Matchers}


class LinkedListSpec extends FunSpec with Matchers {
  //TODO: remove code duplication
  //TODO: test LinkedList[String]
  describe("LinkedList - Int") {
    it("sums elements") {
      Pair(1, Pair(2, Pair(3, End()))).fold(0)(_ + _) shouldBe 6
      End[Int]().fold(0)(_ + _) shouldBe 0
    }

    it("returns length of list") {
      End().fold(0)((_, tl) => 1 + tl) shouldBe 0
      Pair(1, End()).fold(0)((_, tl) => 1 + tl) shouldBe 1
      Pair(1, Pair(2, Pair(3, End()))).fold(0)((_, tl) => 1 + tl) shouldBe 3
    }

    it("doubles elements") {
      (End(): LinkedList[Int]).fold(End(): LinkedList[Int])((h, t) => Pair(h * 2, t)) shouldBe End()
      Pair(1, End()).fold(End(): LinkedList[Int])((h, t) => Pair(h * 2, t)) shouldBe Pair(2, End())
      Pair(1, Pair(2, End())).fold(End(): LinkedList[Int])((h, t) => Pair(h * 2, t)) shouldBe Pair(2, Pair(4, End()))
    }
  }

  describe("multiple parameter list for type inference") {
    it("requires type in single parameter list") {
      val list = Pair(1, Pair(2, End()))
      //NOTE: fold(B)((A, B) => B) - the second B can be inferred
      list.fold(0)(_ + _) shouldBe 3
      //NOTE: fold2(B, (A, B) => B) - the second B cannot be inferred
      list.fold2(0, (x, y: Int) => x + y) shouldBe 3
    }
  }

  describe("map") {
    it("transfers A to B") {
      End[Int]().map(_.toString) shouldBe End[String]()
      Pair(2, End()).map(_.toString) shouldBe Pair("2", End())
      Pair(1, Pair(2, End()))
        .map(_.toString) shouldBe Pair("1", Pair("2", End()))
    }
  }
}

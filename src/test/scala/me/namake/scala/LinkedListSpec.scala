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
}

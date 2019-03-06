package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class MaybeSpec extends FunSpec with Matchers {

  describe("fold2 - with redundant recursive type") {
    it("returns value if exists or default value otherwise") {
      (Empty(): Maybe[Int]).fold2("empty")((h, _) => h.toString) shouldBe "empty"
      (Full(1): Maybe[Int]).fold2("empty")((h, _) => h.toString) shouldBe "1"

      (Empty(): Maybe[Int]).fold2(0)((h, t) => h + t) shouldBe 0
      (Full(3): Maybe[Int]).fold2(0)((h, t) => h + t) shouldBe 3
    }
  }

  describe("fold - simpler interface") {
    it("returns value if exists or default value otherwise") {
      (Empty(): Maybe[Int]).fold("empty")(_.toString) shouldBe "empty"
      (Full(1): Maybe[Int]).fold("empty")(_.toString) shouldBe "1"

      (Empty(): Maybe[Int]).fold(0)(x => x) shouldBe 0
      (Full(3): Maybe[Int]).fold(0)(x => x) shouldBe 3
    }
  }

  describe("flatMap") {
    it("returns Maybe[B] when A => Maybe[B] is given") {
      Empty[Int]().flatMap(x => Full(x.toString)) shouldBe Empty[String]()
      Full(1).flatMap(x => Full(x.toString)) shouldBe Full("1")
    }
  }
}

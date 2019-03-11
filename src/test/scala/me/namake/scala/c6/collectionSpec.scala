package me.namake.scala.c6

import org.scalatest.{FunSpec, Matchers}

class collectionSpec extends FunSpec with Matchers {

  describe("Seq") {
    it("append element") {
      val seq1: Seq[String] = collection.animals :+ "tyrannosaurus"
      seq1 shouldBe Seq("cat", "dog", "tyrannosaurus")
    }

    it("prepend element") {
      val seq1: Seq[String] = "mouse" +: collection.animals
      seq1 shouldBe Seq("mouse", "cat", "dog")
    }

    it("prepend a different type") {
      // the least upper bound of String and Int is Any
      val seq1: Seq[Any] = 2 +: collection.animals
      seq1 shouldBe Seq(2, "cat", "dog")
    }
  }
}

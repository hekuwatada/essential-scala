package me.namake.scala.misc.polymorphic

import org.scalatest.{FunSpec, Matchers}

class animalOpsSpec extends FunSpec with Matchers {

  val zebra = ZebraX(fitness = 5, 10)
  val giraffe = GiraffeX(fitness = 2)
  val giraffe2 = GiraffeX(fitness = 6)
  val animal: Animal = new Animal {
    override def fitness: Int = 3
  }

  describe("passing Animal types") {
    it("subtypes Animal") {
      animalOps.selectFitter1(zebra, giraffe) shouldBe zebra
      animalOps.selectFitter1(animal, giraffe) shouldBe animal
    }

    it("takes subtype of Animal") {
      // cannot force x and y to be the same type
      animalOps.selectFitter2(zebra, giraffe) shouldBe zebra
      animalOps.selectFitter2(animal, giraffe) shouldBe animal
    }

    it("accepts only the same type") {
      pending
      animalOps.selectFitter3(zebra, zebra) shouldBe zebra
      animalOps.selectFitter3(zebra, giraffe) shouldBe zebra // Not compiling
      animalOps.selectFitter3(giraffe, giraffe2) shouldBe giraffe2
    }
  }
}

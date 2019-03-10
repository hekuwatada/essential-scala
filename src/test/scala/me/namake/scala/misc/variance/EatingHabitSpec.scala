package me.namake.scala.misc.variance

import me.namake.scala.misc._
import org.scalatest.{FunSpec, Matchers}

class EatingHabitSpec extends FunSpec with Matchers {

  describe("function") {
    // accepts supertype of f: Cat => SmallAnimal
    it("accepts contravariant arguments and covariant return type") {
      val eatRat = new EatingHabit {}
      val catSmall: Cat => SmallAnimal = (_) => Rat
      val catMouse: Cat => Mouse = (_) => Rat
      val animalSmall: Animal => SmallAnimal = (_) => Rat
      val animalMouse: Animal => Mouse = (_) => Rat
      val animalAnimal: Animal => Animal = (_) => Rat // Animal return type not compiling
      val oswaldMouse: Oswald => Mouse = (_) => Rat // Oswald arg type not compiling
      val cat: Cat = new Cat { val name = "cat" }
      eatRat.findFood(cat)(catMouse)
      eatRat.findFood(Oswald())(animalMouse)
//      eatRat.findFood(Oswald())(oswaldMouse) // Oswald => Mouse does not compile
      eatRat.findFood(cat)(catSmall)
      eatRat.findFood(cat)(animalSmall)
//      eatRat.findFood(Cat("cat"))(animalAnimal) // Animal => Animal does not compile
    }
  }
}

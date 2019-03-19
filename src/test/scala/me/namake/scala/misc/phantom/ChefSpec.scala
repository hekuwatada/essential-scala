package me.namake.scala.misc.phantom

import me.namake.scala.misc.phantom.Pizza.{Cheese, EmptyPizza, FullPizza}
import org.scalatest.{FunSpec, Matchers}

class ChefSpec extends FunSpec with Matchers {

  describe("Builder pattern with phantom type") {
    it("builds empty pizza") {
      //TODO: below should not be allowed
      new Chef[EmptyPizza](Seq("cheese", "dough", "topping"))

      Chef().ingredients shouldBe empty
    }

    it("builds non-empty pizza") {
      /*
        NOTE: trying to build without necessary ingredients causes below compilation error
        Error: Cannot prove that EmptyPizza =:= FullPizza.
        Chef().build
       */
      //Chef().build //Not compiling
      val food = Chef().addDough("buckwheat")
          .addCheese("oak smoked")
          .addTopping("anchovy")
          .build

      food shouldBe Food(Seq("buckwheat", "oak smoked", "anchovy"))
    }
  }
}


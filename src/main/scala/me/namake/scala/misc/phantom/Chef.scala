package me.namake.scala.misc.phantom

import me.namake.scala.misc.phantom.Pizza._

// Pizza builder
//TODO: difficult to ensure integrity between P and initial ingredients
// as new Chef[EmptyPizza](Seq("cheese", "topping", "dough")) is possible
class Chef[P <: Pizza](val ingredients: Seq[String] = Seq.empty[String]) {

  //NOTE: builder method will return original Pizza type with added ingredients
  def addDough(dough: String): Chef[P with Dough] =
    new Chef(ingredients :+ dough)

  def addCheese(cheese: String): Chef[P with Cheese] =
    new Chef(ingredients :+ cheese)

  def addTopping(topping: String): Chef[P with Topping] =
    new Chef(ingredients :+ topping)

  def build(implicit ev: P =:= FullPizza): Food =
    Food(ingredients)
}

object Chef {
  def apply(): Chef[EmptyPizza] = new Chef[EmptyPizza](Seq.empty[String])
}


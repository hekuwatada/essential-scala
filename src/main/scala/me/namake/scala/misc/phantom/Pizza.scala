package me.namake.scala.misc.phantom

sealed trait Pizza

object Pizza {
  sealed trait EmptyPizza extends Pizza
  sealed trait Cheese extends Pizza
  sealed trait Topping extends Pizza
  sealed trait Dough extends Pizza

  // AND type constraints
  type FullPizza = EmptyPizza with Cheese with Topping with Dough
}
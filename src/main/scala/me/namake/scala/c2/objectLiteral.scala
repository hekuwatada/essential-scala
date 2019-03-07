package me.namake.scala.c2

object objectLiteral {

  // apply() makes the object look like a function
  object addOne {
    def apply(x: Int): Int = x + 1
  }

  // declaration (not expression)
  object TestObject {}
}



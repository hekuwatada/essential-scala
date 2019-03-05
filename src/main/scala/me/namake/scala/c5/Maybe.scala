package me.namake.scala.c5

/**
  * Sum type pattern - Scala provides Option
  */
trait Maybe[A] {
  /**
    * Fold pattern - transforms A to B with termination/base of type B
    */
  def fold[B](empty: B)(f: A => B): B =
    this match {
      case Empty() => empty
      case Full(value) => f(value)
    }

  // Assume B is recursive - B is redundant for Maybe
  def fold2[B](end: B)(f: (A, B) => B): B =
    this match {
      case Empty() => end
      case Full(value) => f(value, end)
    }
}

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]
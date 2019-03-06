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

  /**
    * flatMap - For F[A] and A => F[B], return F[B]
    */
  // Monad
  def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    this match {
      case Empty() => Empty[B]()
      case Full(value) => f(value)
    }

  /**
    * map - Given A => B, return F[B]
    */
  // Functor
  def map[B](f: A => B): Maybe[B] = flatMap(f.andThen(Maybe.pure))

  def map2[B](f: A => B): Maybe[B] =
    this match {
      case Empty() => Empty[B]()
      case Full(value) => Full(f(value))
    }
}

object Maybe {
  def pure[A](a: A): Maybe[A] = Full(a)
}

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]
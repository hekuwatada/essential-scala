package me.namake.scala.c5

/**
  * Covariant Sum type pattern (OR) - Scala provides Either
  */
trait Sum[+A, +B] {

  def fold[C](leftF: A => C, rightF: B => C): C =
    this match {
      case Left(value) => leftF(value)
      case Right(value) => rightF(value)
    }

  // Right-biased map
  def map[C](rightF: B => C): Sum[A, C] =
    flatMap(rightF.andThen(Right(_)))

  // Right-biased flatMap
  def flatMap[BB >: B, AA >: A, C](rightF: BB => Sum[AA, C]): Sum[AA, C] =
    this match {
      case Left(value) => Left(value)
      case Right(value) => rightF(value)
    }
}

final case class Left[A](value: A) extends Sum[A, Nothing]
final case class Right[B](value: B) extends Sum[Nothing, B]
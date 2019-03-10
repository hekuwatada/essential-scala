package me.namake.scala.c5

/**
  * Covariant Sum type pattern (OR) - Scala provides Either
  */
sealed trait Sum[+A, +B] {

  def fold[C](leftF: A => C, rightF: B => C): C =
    this match {
      case Left(value) => leftF(value)
      case Right(value) => rightF(value)
    }

  // Right-biased map
  def map[C](rightF: B => C): Sum[A, C] =
    flatMap(rightF.andThen(Right(_)))

  // Right-biased flatMap
  // Error:
  //  covariant type A occurs in contravariant position in type B => Sum[A,C] of value rightF
  // supertype of rightF is accepted
  // C - new type therefore irrelevant
  // B - must be covariant due to variance flip therefore ok
  // A - must be contravariant due to variance flip therefore supertype AA to be introduced
  def flatMap[AA >: A, C](rightF: B => Sum[AA, C]): Sum[AA, C] =
    this match {
      case Left(value) => Left(value)
      case Right(value) => rightF(value)
    }
}

final case class Left[A](value: A) extends Sum[A, Nothing]
final case class Right[B](value: B) extends Sum[Nothing, B]
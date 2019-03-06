package me.namake.scala.c5

/**
  * Sum type pattern (OR) - Scala provides Either
  */
trait Sum[A, B] {

  def fold[C](leftF: A => C, rightF: B => C): C =
    this match {
      case Left(value) => leftF(value)
      case Right(value) => rightF(value)
    }

  // Right-biased map
  def map[C](rightF: B => C): Sum[A, C] =
    this match {
      case Left(value) => Left(value)
      case Right(value) => Right(rightF(value))
    }

  // Right-biased flatMap
  def flatMap[C](rightF: B => Sum[A, C]): Sum[A, C] =
    this match {
      case Left(value) => Left(value)
      case Right(value) => rightF(value)
    }
}

final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]
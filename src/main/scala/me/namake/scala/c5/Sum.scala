package me.namake.scala.c5

/**
  * Sum type pattern (OR) - Scala provides Either
  */
trait Sum[A, B]

final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]
package me.namake.scala.c3

object divide {
  def apply(dividend: Int, divisor: Int): DivisionResult =
    if (divisor > 0) Finite(dividend / divisor) else Infinite
}

sealed trait DivisionResult
final case class Finite(value: Int) extends DivisionResult
case object Infinite extends DivisionResult
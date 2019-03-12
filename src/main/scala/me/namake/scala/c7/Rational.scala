package me.namake.scala.c7

final case class Rational(numerator: Int, denominator: Int)

object Rational {
  implicit val ordering: Ordering[Rational] = Ordering.fromLessThan((x, y) =>
    x.numerator * y.denominator < y.numerator * x.denominator
  )
}
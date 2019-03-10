package me.namake.scala.c5.s6

import me.namake.scala.c5._
import me.namake.scala.c5.s6.Expression.{CalcResult, binaryOp}

sealed trait Expression {
  def eval: CalcResult
}

object Expression {
  type CalcResult = Sum[String, Double]

  def binaryOp(left: CalcResult, right: CalcResult, op: (Double, Double) => Double): CalcResult =
    (left, right) match {
      case (Right(l), Right(r)) => Right(op(l, r))
      case (Right(_), Left(r)) => Left(r)
      case (Left(l), Right(_)) => Left(l)
      case (Left(l), Left(r)) => Left(l + r)
    }
}

final case class Addition(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult = binaryOp(left.eval, right.eval, (x, y) => x + y)
}

final case class Subtraction(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult = binaryOp(left.eval, right.eval, (x, y) => x - y)
}

final case class Division(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult = {
    val rightValue = right.eval.flatMap {
      case v if v == 0 => Left("Division by zero")
      case v => Right(v)
    }
    binaryOp(left.eval, rightValue, (x, y) => x / y)
  }
}

final case class SquareRoot(value: Expression) extends Expression {
  override def eval: CalcResult =
    value.eval.flatMap {
      case v if v < 0 => Left("Square root of negative number")
      case v => Right(Math.sqrt(v))
    }
}

final case class Number(value: Double) extends Expression {
  override def eval: CalcResult = Right(value)
}
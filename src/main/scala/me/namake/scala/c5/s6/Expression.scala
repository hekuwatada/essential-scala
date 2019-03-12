package me.namake.scala.c5.s6

import me.namake.scala.c5._
import me.namake.scala.c5.s6.Expression.{CalcResult, liftTwo}

sealed trait Expression {
  def eval: CalcResult
}

object Expression {
  type CalcResult = Sum[String, Double]

  //NOTE: has the ability to combine two failures
  def binaryOp(left: CalcResult, right: CalcResult, op: (Double, Double) => Double): CalcResult =
    (left, right) match {
      case (Right(l), Right(r)) => Right(op(l, r))
      case (Right(_), Left(r)) => Left(r)
      case (Left(l), Right(_)) => Left(l)
      case (Left(l), Left(r)) => Left(l + r)
    }

  //TODO: keep both failures
  //NOTE: has the ability for the binary operation to return failure
  def liftTwo(left: CalcResult, right: CalcResult, op: (Double, Double) => CalcResult): CalcResult =
    left.flatMap { l: Double =>
      right.flatMap { r: Double =>
        op(l, r)
      }
    }

  // flatMap + map => for comprehension
//  def liftTwo2(left: CalcResult, right: CalcResult, op: (Double, Double) => CalcResult): Sum[String, Double] =
//    for {
//      l: Double <- left
//      r: Double <- right
//      result: Double <- op(l, r)
//    } yield result
}

final case class Addition(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult = liftTwo(left.eval, right.eval, (x, y) => Right(x + y))
}

final case class Subtraction(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult = liftTwo(left.eval, right.eval, (x, y) => Right(x - y))
}

final case class Division(left: Expression, right: Expression) extends Expression {
  override def eval: CalcResult =
    liftTwo(left.eval, right.eval, (x, y) => if (y == 0) Left("Division by zero") else Right(x / y))
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
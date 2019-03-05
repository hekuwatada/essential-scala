package me.namake.scala

sealed trait IntList {
  def product: Int =
    abstraction(1, (x, y) => x * y)

  def sum: Int =
    abstraction(0, (x, y) => x + y)

  def abstraction(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(head, tail) => f(head, tail.abstraction(end, f))
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

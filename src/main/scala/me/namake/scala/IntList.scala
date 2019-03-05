package me.namake.scala

sealed trait IntList {
  def sum: Int = fold(0)((x, y) => x + y)

  def length: Int =
    this match {
      case End => 0
      case Pair(_, tail) => 1 + tail.length
    }

  def product: Int = fold(1)((x, y) => x * y)

  def fold(end: Int)(f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(head, tail) => f(head, tail.fold(end)(f))
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

package me.namake.scala

sealed trait IntList {
  def product: Int =
    this match {
      case End => 1
      case Pair(head, tail) => head * tail.product
    }

  def sum: Int =
    this match {
      case End => 0
      case Pair(head, tail) => head + tail.sum
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

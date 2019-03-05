package me.namake.scala

sealed trait IntList {
  def sum: Int = fold(0)(_ + _)

  def product: Int = fold(1)(_ * _)

  def length: Int = fold(0)((_, y) => 1 + y)

  def double: IntList = fold(End: IntList)((el, list) => Pair(el * 2, list))

  //TODO: make it tail recursive
  def fold[A](end: A)(f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(head, tail) => f(head, tail.fold(end)(f))
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

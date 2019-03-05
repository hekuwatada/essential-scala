package me.namake.scala

sealed trait IntList {
  def sum: Int = fold(0)(_ + _)

  def product: Int = fold(1)(_ * _)

  def length: Int = fold(0)((_, tail) => 1 + tail)

  def double: IntList = fold(IntListEnd: IntList)((head, tail) => IntListPair(head * 2, tail))

  //TODO: make it tail recursive
  def fold[A](end: A)(f: (Int, A) => A): A =
    this match {
      case IntListEnd => end
      case IntListPair(head, tail) => f(head, tail.fold(end)(f))
    }
}

case object IntListEnd extends IntList
final case class IntListPair(head: Int, tail: IntList) extends IntList

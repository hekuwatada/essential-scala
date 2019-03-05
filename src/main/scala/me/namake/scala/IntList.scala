package me.namake.scala

sealed trait IntList {
  def sum: Int = fold(0)(_ + _)

  def sum2: Int = this match {
    case IntListEnd => 0
    case IntListPair(head, tail) => head + tail.sum2
  }

  def product: Int = fold(1)(_ * _)

  def product2: Int = this match {
    case IntListEnd => 1
    case IntListPair(head, tail) => head * tail.product2
  }

  def length: Int = fold(0)((_, tail) => 1 + tail)

  def length2: Int = this match {
    case IntListEnd => 0
    case IntListPair(_, tail) => 1 + tail.length2
  }

  def double: IntList = fold(IntListEnd: IntList)((head, tail) => IntListPair(head * 2, tail))

  def double2: IntList = this match {
    case IntListEnd => IntListEnd
    case IntListPair(head, tail) => IntListPair(head * 2, tail.double2)
  }

  //TODO: make it tail recursive
  def fold[A](end: A)(f: (Int, A) => A): A =
    this match {
      case IntListEnd => end
      case IntListPair(head, tail) => f(head, tail.fold(end)(f))
    }
}

case object IntListEnd extends IntList
final case class IntListPair(head: Int, tail: IntList) extends IntList

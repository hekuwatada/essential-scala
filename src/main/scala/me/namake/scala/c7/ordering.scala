package me.namake.scala.c7

object ordering {

  val absOrdering: Ordering[Int] = new Ordering[Int] {
    override def compare(x: Int, y: Int): Int =
      Integer.compare(Math.abs(x), Math.abs(y))
  }

  // Single abstract method equivalent to above absOrdering
  val absOrdering2: Ordering[Int] =
    (x: Int, y: Int) => Integer.compare(Math.abs(x), Math.abs(y))

  implicit val absOrdering3: Ordering[Int] = Ordering.fromLessThan((x, y) => Math.abs(x) < Math.abs(y))
}

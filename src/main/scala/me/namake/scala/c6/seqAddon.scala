package me.namake.scala.c6

//TODO: implement implicit class for Seq
object seqAddon {

  def minOption(col: Seq[Int]): Option[Int] = col.sorted.headOption

  def min(col: Seq[Int]): Int = col.foldLeft(Int.MaxValue)(Math.min)

  //TODO: implement map with foldLeft
  def map[A, B](col: Seq[A])(f: A => B): Seq[B] =
    col.foldRight(Seq.empty[B])((x, acc) => f(x) +: acc)

  def foldLeft[A, B](col: Seq[A])(z: B)(f: (B, A) => B): B = {
    var acc: B = z
    col.foreach((x: A) => acc = f(acc, x))
    acc
  }
}

package me.namake.scala.c6

//TODO: implement implicit class for Seq
object seqAddon {

  def min(col: Seq[Int]): Option[Int] = col.sorted.headOption
}

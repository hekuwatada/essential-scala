package me.namake.scala.c6

//TODO: implement implicit class for Seq
object seqAddon {

  def minOption(col: Seq[Int]): Option[Int] = col.sorted.headOption

  def min(col: Seq[Int]): Int = col.foldLeft(Int.MaxValue)(Math.min)
}

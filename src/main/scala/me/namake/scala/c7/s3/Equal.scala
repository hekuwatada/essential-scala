package me.namake.scala.c7.s3

trait Equal[A] {
  def equal(x: A, y: A): Boolean
}

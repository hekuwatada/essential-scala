package me.namake.scala.c7.s3

trait Equal[A] {
  def equal(x: A, y: A): Boolean
}

object Equal {
  // no-argument apply method
  def apply[A](implicit instance: Equal[A]): Equal[A] = instance
}
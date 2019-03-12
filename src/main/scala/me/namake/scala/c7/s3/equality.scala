package me.namake.scala.c7.s3

object equality {
  // Single Abstract Method
  val personEquality: Equal[Person] = (x, y) => x.email == y.email
}

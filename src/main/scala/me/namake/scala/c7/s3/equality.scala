package me.namake.scala.c7.s3

object equality {
  val personEquality: Equal[Person] = new Equal[Person] {
    override def equal(x: Person, y: Person): Boolean = x.email == y.email
  }
}

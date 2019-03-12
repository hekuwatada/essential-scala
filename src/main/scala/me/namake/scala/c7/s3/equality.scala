package me.namake.scala.c7.s3

object equality {
  // Single Abstract Method
  object personEqualityByEmail {
    val equality: Equal[Person] = (x, y) => x.email == y.email
  }

  object personEqualityByNameEmail {
    val equality: Equal[Person] = (x, y) => x.name == y.name && x.email == y.email
  }
}

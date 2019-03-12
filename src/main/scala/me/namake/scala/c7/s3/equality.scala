package me.namake.scala.c7.s3

object equality {
  // Single Abstract Method
  object personEqualityByEmail {
    implicit val eq: Equal[Person] = (x, y) => x.email == y.email
  }

  object personEqualityByNameEmail {
    implicit val eq: Equal[Person] = (x, y) => x.name == y.name && x.email == y.email
  }

  object Eq {
    def apply[A](x: A, y: A)(implicit eq: Equal[A]): Boolean = eq.equal(x, y)
  }
}

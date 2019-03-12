package me.namake.scala.c7.s3

object equality {
  object personEqualityByEmailImplicit {
    implicit object eq extends Equal[Person] {
      override def equal(x: Person, y: Person): Boolean = x.email == y.email
    }
  }

  object personEqualityByNameEmailImplicit {
    implicit object eq extends Equal[Person] {
      override def equal(x: Person, y: Person): Boolean =
        x.name == y.name && x.email == y.email
    }
  }

  object Eq {
    def apply[A](x: A, y: A)(implicit eq: Equal[A]): Boolean = eq.equal(x, y)
  }
}

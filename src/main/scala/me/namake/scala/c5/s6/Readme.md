5.6 Variance

Given A is a supertype of B 


*invariance* (default in Scala)

Foo[T] is invariance in terms of T

Meaning: Foo[A] and Foo[B] are unrelated


*covariance* (e.g. Scala collections)

Foo[+T] is covariance in terms of T

Meaning: Foo[A] is a supertype of Foo[B]


*contravariance* (e.g. function arguments)

Foo[-T] is contravariance in terms of T

Meaning: Foo[A] is a subtype of Foo[B]


Functions

e.g.

trait Function1[-A, +B] {
  def apply(a: A): B 
}

arguments - contravariant
return type - covariant

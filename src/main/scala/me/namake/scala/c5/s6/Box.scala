package me.namake.scala.c5.s6

case class Box[+A](value: A) {
//  def map[B](f: Function1[A, B]): Box[B] = Box(f(value))

  // set[A](a: A): Box[A] will cause below error:
  // "covariant type A occurs in contravariant position in type A of value a"
  // for function arguments are contravariant.
  // solution: introduce a new type AA that is a super type of A.
  def set[AA >: A](a: AA): Box[AA] = Box(a)

  // NOTE: For higher order function, variant will be flipped.
  // def foo(f: A => B) = ???
  // f must be contravariant. A => B follows Function1[+T, -R].
  // contravariant of contravariant +T = covariant
  // contravariant of covariant -R = contravariant
  // Therefore, in f, A must be covariant and B must be contravariant

  // variant flip #1
  // A is covariant
  // B is invariant and can appear anywhere
  def map[B](f: A => B): Box[B] = ???

  // variant flip #2
  // below does not compile due to covariant A appearing in contravariant position
  // as return type of f
//  def tuple[B](b: B)(f: (B, A) => (A, B)): (A, B) = ???
  // solution: introduce supertype AA of A so that AA is contravariant
  def tuple[AA >: A, B](b: B)(f: (B, AA) => (AA, B)): (AA, B) = ???
}
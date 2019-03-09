package me.namake.scala.c5.s6

case class Box[+A](value: A) {
//  def map[B](f: Function1[A, B]): Box[B] = Box(f(value))

  // set[A](a: A): Box[A] will cause below error:
  // "covariant type A occurs in contravariant position in type A of value a"
  // for function arguments are contravariant.
  // solution: introduce a new type AA that is a super type of A.
  def set[AA >: A](a: AA): Box[AA] = Box(a)
}
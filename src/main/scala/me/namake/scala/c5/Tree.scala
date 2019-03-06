package me.namake.scala.c5


//TODO: Add empty tree
sealed trait Tree[A] {
  // separated two functions to infer B in nodeF
  // depth-first search
  //TODO: make it tail recursive
  def fold[B](leafF: A => B)(nodeF: (B, B) => B): B =
    this match {
      case Leaf(el) => leafF(el)
      case Node(left, right) => nodeF(left.fold(leafF)(nodeF), right.fold(leafF)(nodeF))
    }
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](element: A) extends Tree[A]

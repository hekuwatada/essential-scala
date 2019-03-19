package me.namake.scala

import scala.annotation.tailrec

sealed trait LinkedList[A] {
  /**
    * For an algebraic data type A, fold coverts it to
    * a generic type B
    */
  //TODO: make it tail recursive
  def fold[B](end: B)(f: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.fold(end)(f))
    }

  /**
    * Example to highlight that complier can infer type once per parameter list.
    * It cannot therefore infer type B for f after B for end.
    */
  def fold2[B](end: B, f: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.fold2(end, f))
    }

  //TODO: test
  //TODO: reserve the order of elements
  def fold3[B](end: B)(f: (A, B) => B): B =
    LinkedList.foldRecursive(end, this)(f)

  //TODO: make it tail recursive
  def map[B](f: A => B): LinkedList[B] =
    this match {
      case End() => End[B]()
      case Pair(head, tail) => Pair(f(head), tail.map(f))
    }

  def reverse: LinkedList[A] =
    LinkedList.reverseRecursive(this, End())
}

object LinkedList {
  @tailrec
  def foldRecursive[A, B](end: B, list: LinkedList[A])(f: (A, B) => B): B =
    list match {
      case End() => end
      case Pair(head, tail) => foldRecursive(f(head, end), tail)(f)
    }

  @tailrec
  def reverseRecursive[A](list: LinkedList[A], acc: LinkedList[A]): LinkedList[A] =
    list match {
      case End() => acc
      case Pair(head, End()) => Pair(head, acc)
      case Pair(head, tail) => reverseRecursive(tail, Pair(head, acc))
    }
}

//TODO: re-implement methods for IntList as LinkedList[Int]
final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
package me.namake.scala.c6

import me.namake.scala.c5.Maybe

object forComprehension {

  def addMaybe(maybeX: Maybe[Int], maybeY: Maybe[Int]): Maybe[Int] =
    for {
      x <- maybeX
      y <- maybeY
    } yield x + y
}

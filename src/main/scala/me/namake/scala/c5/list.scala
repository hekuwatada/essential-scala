package me.namake.scala.c5

object list {

  def addNegative(list: List[Int]): List[Int] = list.flatMap(x => List(x, -x))

  //TODO: use flatMap
  def removeOdd(list: List[Maybe[Int]]): List[Maybe[Int]] =
    list.map {
      case Full(x) if x % 2 != 0 => Empty
      case maybe => maybe
    }

  def removeOdd2(list: List[Maybe[Int]]): List[Maybe[Int]] =
    list.map {
      case Full(x) if x % 2 != 0 => Empty
      case maybe => maybe
    }
}

package me.namake.scala.c7

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

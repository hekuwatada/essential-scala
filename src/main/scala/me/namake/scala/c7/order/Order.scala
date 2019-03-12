package me.namake.scala.c7.order

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object Order {
  implicit val ordering: Ordering[Order] = implicits.orderByTotalPrice.ordering
}

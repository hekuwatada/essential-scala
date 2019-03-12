package me.namake.scala.c7.order

/*
  Implicit ordering instances defined in separate objects to avoid accidental import.
 */
object implicits {
  object orderByTotalPrice {
    implicit val ordering: Ordering[Order] = Ordering.fromLessThan((x, y) => x.totalPrice < y.totalPrice)
  }

  object orderByUnitsCount {
    implicit val ordering: Ordering[Order] = Ordering.fromLessThan((x, y) => x.units < y.units)
  }

  object orderByUnitPrice {
    implicit val ordering: Ordering[Order] = Ordering.fromLessThan((x, y) => x.unitPrice < y.unitPrice)
  }
}

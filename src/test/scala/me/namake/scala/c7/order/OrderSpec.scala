package me.namake.scala.c7.order

import org.scalatest.{FunSpec, Matchers}

class OrderSpec extends FunSpec with Matchers {

  describe("ordering") {
    val orders = Seq(Order(5, 9.5), Order(2, 20.0), Order(1, 100))

    it("orders by total price by default") {
      orders.sorted shouldBe Seq(Order(2, 20.0), Order(5, 9.5), Order(1, 100))
    }

    it("orders by number of units") {
      import implicits.orderByUnitsCount._
      orders.sorted shouldBe Seq(Order(1, 100), Order(2, 20.0), Order(5, 9.5))
    }

    it("orders by unit price") {
      import implicits.orderByUnitPrice._
      orders.sorted shouldBe Seq(Order(5, 9.5), Order(2, 20.0), Order(1, 100))
    }
  }
}

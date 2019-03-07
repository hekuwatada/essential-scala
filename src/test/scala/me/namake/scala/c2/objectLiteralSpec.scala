package me.namake.scala.c2

import me.namake.scala.c2.objectLiteral.{TestObject, addOne}
import org.scalatest.{FunSpec, Matchers}

class objectLiteralSpec extends FunSpec with Matchers {

  describe("object with apply()") {
    it("makes object look like function") {
      addOne(1) shouldBe 2
    }
  }

  describe("object declaration") {
    it("has singleton type when evaluated") {
      TestObject shouldBe a[objectLiteral.TestObject.type]
    }
  }
}

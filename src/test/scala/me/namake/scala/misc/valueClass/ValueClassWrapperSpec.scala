package me.namake.scala.misc.valueClass

import org.scalatest.{FunSpec, Matchers}

class ValueClassWrapperSpec extends FunSpec with Matchers {
  describe("Value Type") {
    it("instantiates Wrapper object three times") {
      Wrapper(1) + Wrapper(2) shouldBe Wrapper(3)
    }

    it("acts as wrapper at compile time but as Int at runtime") {
      ValueClassWrapper(1) + ValueClassWrapper(2) shouldBe ValueClassWrapper(3)
    }
  }
}

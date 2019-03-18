package me.namake.scala.misc.valueType

import org.scalatest.{FunSpec, Matchers}

class IntAddonSpec extends FunSpec with Matchers {
  describe("implicit class") {
    it("enriches Int with method - plain") {
      import me.namake.scala.misc.valueType.IntAddon._

      42.toHexStr shouldBe "2a"
    }

    it("enriched Int as value class with AnyVal") {
      import me.namake.scala.misc.valueType.IntAddon._

      // toStr is a static method call
      42.toStr shouldBe "42"
    }
  }
}

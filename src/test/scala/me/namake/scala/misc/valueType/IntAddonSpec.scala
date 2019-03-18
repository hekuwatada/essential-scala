package me.namake.scala.misc.valueType

import org.scalatest.{FunSpec, Matchers}

class IntAddonSpec extends FunSpec with Matchers {
  describe("implicit class") {
    it("enriches Int with method") {
      import me.namake.scala.misc.valueType.IntAddon._

      42.toHexStr shouldBe "2a"
    }
  }
}

package me.namake.scala.misc

import me.namake.scala.misc.composition.{f, g}
import org.scalatest.{FunSpec, Matchers}

class compositionSpec extends FunSpec with Matchers {

  describe("function composition") {
    it("f andThen g = g after f") {
      f.andThen(g)(2) shouldBe 8
    }

    it("f compose g = f after g") {
      f.compose(g)(2) shouldBe 6
    }
  }
}

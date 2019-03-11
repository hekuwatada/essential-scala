package me.namake.scala.c6

import me.namake.scala.c5.Full
import me.namake.scala.c6.forComprehension.addMaybe
import org.scalatest.{FunSpec, Matchers}

class forComprehensionSpec extends FunSpec with Matchers {

  describe("addMaybe()") {
    addMaybe(Full(1), Full(2)) shouldBe Full(3)
  }
}

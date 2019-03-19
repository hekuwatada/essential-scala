package me.namake.scala.c5.s6

import me.namake.scala.misc.{EmptyArg, FuncArg, SubStrArg}
import org.scalatest.{FunSpec, Matchers}

class BoxSpec extends FunSpec with Matchers {

  describe("Function arguments A are contravariant") {
    //TODO: if AA <: A, can AA be A?
    //TODO: pass real supertype of A
    it("sets supertype of A") {
      val box1: Box[FuncArg] = Box[FuncArg](EmptyArg)
      val box2: Box[FuncArg] = box1.set(SubStrArg("string", "extra"))
      box2 shouldBe a[Box[SubStrArg]] //TODO: fix compiler warning
    }
  }

  describe("Function return type R is covariant") {
    pending
  }
}

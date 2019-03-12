package me.namake.scala.misc.implicitscope.companionobject

import org.scalatest.{FunSpec, Matchers}

class CompObjScopeASpec extends FunSpec with Matchers {

  describe("companion object scope") {
    it("can have implicit instances that can be found by compiler by default") {
      implicitly[CompObjScopeA[Int]] shouldBe CompObjScopeA(99)
    }

    it("can be overridden by package object scope") {
      implicitly[CompObjScopeA[String]] shouldBe CompObjScopeA("in package object")
    }
  }
}

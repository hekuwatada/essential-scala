package me.namake.scala.misc.implicitscope.packagescope

import org.scalatest.{FunSpec, Matchers}

class packageSpec extends FunSpec with Matchers {

  describe("package object scope") {
    it("has implicits that can be found by compiler by default") {
      implicitly[PackageScopeA[Int]] shouldBe PackageScopeA(42)
      // implicitly[PackageScopeA[String]] shouldBe null // not compiling due to lack of implicit
    }

    it("cannot has implicits to be found by compiler by default in nested object") {
//      implicitly[PackageScopeA[Double]] shouldBe PackageScopeA(1.234) // not compiling
    }
  }
}

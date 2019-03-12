package me.namake.scala.c7.s3

import org.scalatest.{FunSpec, Matchers}

class equalitySpec extends FunSpec with Matchers {

  describe("equality for Person") {
    it("considers identical email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")

      equality.personEqualityByEmail.equality.equal(p1, p1) shouldBe true
      equality.personEqualityByEmail.equality.equal(p1, p2) shouldBe true
      equality.personEqualityByEmail.equality.equal(p1, p3) shouldBe false
    }

    it("considers identical name and email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")
      val p4 = Person("name", "email")

      equality.personEqualityByNameEmail.equality.equal(p1, p1) shouldBe true
      equality.personEqualityByNameEmail.equality.equal(p1, p4) shouldBe true
      equality.personEqualityByNameEmail.equality.equal(p1, p2) shouldBe false
      equality.personEqualityByNameEmail.equality.equal(p1, p3) shouldBe false
    }
  }
}

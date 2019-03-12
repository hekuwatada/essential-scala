package me.namake.scala.c7.s3

import org.scalatest.{FunSpec, Matchers}

class equalitySpec extends FunSpec with Matchers {

  private def testEmailEquality(eq: (Person, Person) => Boolean): Unit = {
    val p1 = Person("name", "email")
    val p2 = p1.copy(name = "another name")
    val p3 = p1.copy(email = "another email")

    eq(p1, p1) shouldBe true
    eq(p1, p2) shouldBe true
    eq(p1, p3) shouldBe false
  }

  private def testNameEmailEquality(eq: (Person, Person) => Boolean): Unit = {
    val p1 = Person("name", "email")
    val p2 = p1.copy(name = "another name")
    val p3 = p1.copy(email = "another email")
    val p4 = Person("name", "email")

    eq(p1, p1) shouldBe true
    eq(p1, p4) shouldBe true
    eq(p1, p2) shouldBe false
    eq(p1, p3) shouldBe false
  }

  describe("equality for Person") {
    it("considers identical email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")

      equality.personEqualityByEmail.eq.equal(p1, p1) shouldBe true
      equality.personEqualityByEmail.eq.equal(p1, p2) shouldBe true
      equality.personEqualityByEmail.eq.equal(p1, p3) shouldBe false
    }

    it("considers identical name and email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")
      val p4 = Person("name", "email")

      equality.personEqualityByNameEmail.eq.equal(p1, p1) shouldBe true
      equality.personEqualityByNameEmail.eq.equal(p1, p4) shouldBe true
      equality.personEqualityByNameEmail.eq.equal(p1, p2) shouldBe false
      equality.personEqualityByNameEmail.eq.equal(p1, p3) shouldBe false
    }
  }

  describe("type class interface pattern") {
    it("considers identical email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")

      import equality.personEqualityByEmail.{eq => eqF}

      equality.Eq(p1, p1) shouldBe true
      equality.Eq(p1, p2) shouldBe true
      equality.Eq(p1, p3) shouldBe false
    }

    it("considers identical name and email addresses as equal") {
      val p1 = Person("name", "email")
      val p2 = p1.copy(name = "another name")
      val p3 = p1.copy(email = "another email")
      val p4 = Person("name", "email")

      import equality.personEqualityByNameEmail.{eq => eqF}

      equality.Eq(p1, p1) shouldBe true
      equality.Eq(p1, p4) shouldBe true
      equality.Eq(p1, p2) shouldBe false
      equality.Eq(p1, p3) shouldBe false
    }
  }
}

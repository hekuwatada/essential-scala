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
      testEmailEquality(equality.personEqualityByEmailImplicit.eq.equal)
    }

    it("considers identical name and email addresses as equal") {
      testNameEmailEquality(equality.personEqualityByNameEmailImplicit.eq.equal)
    }
  }

  describe("type class pattern") {
    it("considers identical email addresses as equal") {
      testEmailEquality((x, y) => {
        import equality.personEqualityByEmailImplicit.{eq => eqImplicit}
        equality.Eq(x, y)
      })
    }

    it("considers identical name and email addresses as equal") {
      testNameEmailEquality((x, y) => {
        import equality.personEqualityByNameEmailImplicit.{eq => eqImplicit}
        equality.Eq(x, y)
      })
    }
  }

  describe("type class pattern") {
    it("returns implicit Equal instance") {
      testEmailEquality((x, y) => {
        import equality.personEqualityByEmailImplicit.{eq => eqImplicit}
        //NOTE: two helper interfaces
        // 1. equality.Eq[A](..)(implicit eq: Equal[A])
        // 2. Equal[A](implicit eq: Equal[A])
        Equal[Person].equal(x, y)
      })
    }
  }
}

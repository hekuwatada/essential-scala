package me.namake.scala.c5

import org.scalatest.{FunSpec, Matchers}

class TreeSpec extends FunSpec with Matchers {

  describe("data structure") {
    it("tree is a leaf") {
      Leaf("l1") shouldBe a[Tree[_]]
      Leaf(0) shouldBe a[Tree[_]]
    }

    it("tree is a node with left and right tree") {
      Node(Leaf(0), Leaf(1)) shouldBe a[Tree[_]]
      Node(Leaf(0), Node(Leaf(1), Leaf(2))) shouldBe a[Tree[_]]
      Node(Node(Leaf(0), Leaf(3)), Node(Leaf(1), Leaf(2))) shouldBe a[Tree[_]]
    }
  }

  describe("fold") {
    it("sums all elements") {
      Leaf(3).fold(x => x)(_ + _) shouldBe 3
      Node(Node(Node(Leaf(4), Leaf(3)), Leaf(5)), Node(Leaf(1), Leaf(2))).fold(x => x)(_ + _) shouldBe 15
    }

    it("doubles all elements") {
      //TODO: remove type B
      Leaf(3).fold[Tree[Int]](x => Leaf(x * 2))((l, r) => Node(l, r)) shouldBe Leaf(6)
      Node(Node(Node(Leaf(4), Leaf(3)), Leaf(5)), Node(Leaf(1), Leaf(2)))
        .fold[Tree[Int]](x => Leaf(x * 2))((l, r) => Node(l, r)) shouldBe Node(Node(Node(Leaf(8), Leaf(6)), Leaf(10)), Node(Leaf(2), Leaf(4)))
    }

    it("counts number of leaves") {
      Leaf(3).fold(_ => 1)(_ + _) shouldBe 1
      Node(Node(Node(Leaf(4), Leaf(3)), Leaf(5)), Node(Leaf(1), Leaf(2))).fold(_ => 1)(_ + _) shouldBe 5
    }

    it("counts number of nodes") {
      Leaf(3).fold(_ => 0)(_ + _ + 1) shouldBe 0
      Node(Node(Node(Leaf(4), Leaf(3)), Leaf(5)), Node(Leaf(1), Leaf(2))).fold(_ => 0)(_ + _ + 1) shouldBe 4
    }

    it("converts tree to string") {
      val tree: Tree[String] =
        Node(Node(Leaf("To"), Leaf("iterate")),
          Node(Node(Leaf("is"), Leaf("human,")),
            Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

      tree.fold(x => x)(_ + " " + _) shouldBe "To iterate is human, to recurse divine"
    }
  }
}

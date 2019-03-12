package me.namake.scala.misc.implicitscope

package object packagescope {

  implicit val packageScopeIntInstance: PackageScopeA[Int] = PackageScopeA(42)

  object Implicits {
    implicit val nestedObjectDoubleInstance: PackageScopeA[Double] = PackageScopeA(1.234)
  }
}

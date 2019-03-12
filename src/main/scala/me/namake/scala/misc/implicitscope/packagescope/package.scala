package me.namake.scala.misc.implicitscope

package object packagescope {

  implicit val packageScopeIntInstance: PackageScopeA[Int] = PackageScopeA(42)
}

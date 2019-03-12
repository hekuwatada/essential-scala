package me.namake.scala.misc.implicitscope

package object companionobject {

  implicit val compObjScopeString: CompObjScopeA[String] = CompObjScopeA("in package object")
}

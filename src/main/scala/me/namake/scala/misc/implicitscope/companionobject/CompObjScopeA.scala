package me.namake.scala.misc.implicitscope.companionobject

final case class CompObjScopeA[A](value: A)

object CompObjScopeA {
  implicit val compObjScopeInt = CompObjScopeA(99)
}

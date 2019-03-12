package me.namake.scala.misc.implicitscope.companionobject

final case class CompObjScopeA[A](value: A)

object CompObjScopeA {
  implicit val compObjScopeInt = CompObjScopeA(99)
  implicit val compObjScopeString = CompObjScopeA("in companion object")

  object Implicits {
    implicit val compObjScopeDouble = CompObjScopeA(9.876)
  }
}

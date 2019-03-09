package me.namake.scala

package object misc {

  sealed trait FuncArg {
    def name: String = this.getClass.getSimpleName
  }
  case object EmptyArg extends FuncArg
  trait StrArg extends FuncArg {
    def value: String
  }
  case class SubStrArg(value: String, extra: String) extends StrArg

  sealed trait FunReturn
  case object EmptyReturn extends FunReturn
  trait StrReturn extends FunReturn {
    def value: String
  }
  case class SubStrReturn(value: String, extra: String) extends StrReturn
}

package me.namake.scala.misc.valueClass

case class Wrapper(value: Int) {
  def +(that: Wrapper): Wrapper =
    Wrapper(this.value + that.value)
}

case class ValueClassWrapper(value: Int) extends AnyVal {
  def +(that: ValueClassWrapper): ValueClassWrapper =
    ValueClassWrapper(this.value + that.value)
}
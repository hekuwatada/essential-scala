package me.namake.scala.misc.valueType

object IntAddon {
  implicit class ExtendedInt(value: Int) {
    def toHexStr: String = java.lang.Integer.toHexString(value)
  }
}
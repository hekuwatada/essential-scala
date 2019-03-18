package me.namake.scala.misc.valueType

object IntAddon {
  //@see https://docs.scala-lang.org/overviews/core/implicit-classes.html
  implicit class ExtendedInt(value: Int) {
    println("ExtendedInt instantiated")

    def toHexStr: String = java.lang.Integer.toHexString(value)
  }

  //@see https://docs.scala-lang.org/overviews/core/value-classes.html
  implicit class AllocationFreeExtendedInt(val value: Int) extends AnyVal {
    //NOTE: 123.toStr will be called as a static method, as opposed to
    // a new instance of AllocationFreeExtendedInt class created.
    def toStr: String = value.toString
  }
}
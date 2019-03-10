package me.namake.scala.misc.variance

import me.namake.scala.misc.{Cat, SmallAnimal}

//@see https://docs.scala-lang.org/tour/variances.html
trait EatingHabit {
  def findFood(c: Cat)(f: Cat => SmallAnimal): SmallAnimal = f(c)
}

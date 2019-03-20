package me.namake.scala.misc

trait Animal {
  def name: String
}

abstract class Cat extends Animal {
  def meow: String = "meow"
}

case class Oswald() extends Cat {
  val name = "oswald"
}

final case class Dog(name: String) extends Animal

trait SmallAnimal extends Animal //abstract class?

abstract class Mouse extends SmallAnimal
case object Rat extends Mouse {
  val name = "rat"
}

trait Sound
abstract class CatSound() extends Sound
case class Purr() extends CatSound
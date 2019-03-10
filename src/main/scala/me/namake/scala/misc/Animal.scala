package me.namake.scala.misc

trait Animal {
  def name: String
}

case class Cat(name: String) extends Animal
//TODO: do not extend case class
case class Oswald() extends Cat("oswald")

final case class Dog(name: String) extends Animal

trait SmallAnimal extends Animal //abstract class?

case class Mouse(name: String) extends SmallAnimal
case object Rat extends Mouse("rat")

trait Sound
case class CatSound() extends Sound
case class Purr() extends CatSound
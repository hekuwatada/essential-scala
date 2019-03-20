package me.namake.scala.misc.polymorphic

//@see https://www.scala-exercises.org/scala_tutorial/polymorphic_types

trait Animal {
  def fitness: Int
}

trait Reptile extends Animal

trait Mammal extends Animal

trait Zebra extends Mammal {
  def zebraCount: Int
}

trait Giraffe extends Mammal

case class ZebraX(fitness: Int, zebraCount: Int) extends Zebra
case class GiraffeX(fitness: Int) extends Giraffe

object animalOps {

  def selectFitter1(x: Animal, y: Animal): Animal =
    if (x.fitness > y.fitness) x else y

  def selectFitter2[A <: Animal](x: A, y: A): A =
    if (x.fitness > y.fitness) x else y

  //TODO: force x and y to have exactly the same type
  //below wip
  def selectFitter3[A <: Animal](x: A, y: A)(implicit ev: A =:= A): A =
    if (x.fitness > y.fitness) x else y
}
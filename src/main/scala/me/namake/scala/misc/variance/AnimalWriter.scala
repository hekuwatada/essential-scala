package me.namake.scala.misc.variance

import me.namake.scala.misc.{Animal, Cat, Dog, Oswald}

//@see https://docs.scala-lang.org/tour/variances.html
trait Writer[-A] {
  def write(a: A): Unit
}

/*
  @see https://www.scala-exercises.org/scala_tutorial/polymorphic_types
  NOTE:
    if A <: B, where B is used, A can be used (Liskov Substitution Principle)
    Where Writer[Cat] is used, Writer[Animal] can be used; however the inverse is
    not true - Writer[Animal] cannot be substituted for Writer[Cat] as for example
    Writer[Cat] cannot handle Dog. Hence, Writer[Animal] <: Writer[Cat], which is
    covariant.
  */
object AnimalWriter extends Writer[Animal] {
  def write(animal: Animal) = println(animal.name)
}

object CatWriter extends Writer[Cat] {
  def write(cat: Cat) = println(cat.name + cat.meow)
}

class WriterWrapper[A](writer: Writer[A]) {
  def wrap(a: A): Unit = writer.write(a)
}

object writeTest extends App {

  val animal: Animal = new Animal {
    override def name: String = "animal"
  }
  val cat: Cat = new Cat {
    override def name: String = "cat"
  }
  val oswald = Oswald()
  val dog = Dog("akita")

  // Writer[A] is in contravariant position
  def acceptWriter[A](a: A)(writer: Writer[A]):Unit =
    writer.write(a)

  AnimalWriter.write(oswald)
  AnimalWriter.write(dog)
  AnimalWriter.write(animal)
  CatWriter.write(oswald)
  CatWriter.write(cat)
//  CatWriter.write(animal) //Not compiling

  acceptWriter(animal)(AnimalWriter)
  acceptWriter(cat)(AnimalWriter)
  acceptWriter(oswald)(AnimalWriter)
  acceptWriter(dog)(AnimalWriter)
  acceptWriter(cat)(CatWriter)
  acceptWriter(oswald)(CatWriter)
//  acceptWriter(animal)(CatWriter) //Not compiling. writer Writer[Animal] expected
//  acceptWriter(dog)(CatWriter) //Not compiling

  new WriterWrapper(AnimalWriter).wrap(animal)
  new WriterWrapper(AnimalWriter).wrap(cat)
  new WriterWrapper(AnimalWriter).wrap(oswald)
  new WriterWrapper(AnimalWriter).wrap(dog)
  new WriterWrapper(CatWriter).wrap(cat)
  new WriterWrapper(CatWriter).wrap(oswald)
//  new WriterWrapper(CatWriter).wrap(animal) //Not compiling. Cat expected
//  new WriterWrapper(CatWriter).wrap(dog) //Not compiling. Cat expected
}
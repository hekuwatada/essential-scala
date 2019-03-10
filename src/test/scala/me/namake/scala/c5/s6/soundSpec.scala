package me.namake.scala.c5.s6

import me.namake.scala.misc._
import org.scalatest.FunSpec

class soundSpec extends FunSpec {

  describe("groom()") {
    it("accepts contravariant of Cat arg") {
      val catSound: CatSound = new CatSound {}
      sound.groom((_: Cat) => catSound)
      sound.groom((_: Animal) => catSound)
//      sound.groom((_: Dog) => catSound)  // Dog (subtype of Animal) as arg does not compile
//      sound.groom((_: Oswald) => catSound) //Oswald (subtype of Cat) as arg does not compile
    }

    it("accepts covariant of CatSound return type") {
      sound.groom((_: Cat) => Purr())
      val s: Sound = new Sound {}
//      sound.groom((_: Cat) => s) // Sound (supertype of CatSound) as return type dose not compile
    }
  }
}

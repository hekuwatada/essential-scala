package me.namake.scala.c5.s6

import me.namake.scala.misc.{Cat, CatSound}

object sound {
  //TODO: add example with type parameter
  def groom(groomer: Cat => CatSound): CatSound = {
    val blackCat: Cat = new Cat { val name = "black" }
    groomer(blackCat)
  }
}

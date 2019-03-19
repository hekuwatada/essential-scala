package me.namake.scala.misc.phantom

//@see https://medium.com/@maximilianofelice/builder-pattern-in-scala-with-phantom-types-3e29a167e863

// "phantom" types
//NOTE: seal traits to stop them from being actually extended (or used at all?)
sealed trait DoorState
sealed trait Open extends DoorState
sealed trait Closed extends DoorState

case class Door[S <: DoorState]() {
  //NOTE: implicit evidence will bind the S to be a specific DoorState type
  //TODO: add example with conditional statements to check type for comparison
  def open(implicit ev: S =:= Closed): Door[Open] = Door[Open]()
  def close(implicit ev: S =:= Open): Door[Closed] = Door[Closed]()
}

object doorOps extends App {

  /*
    NOTE: Invalid state transition will be caused at compilation time
    Error: Cannot prove that Closed =:= Open.
    Door[Closed]().close
   */
//  Door[Closed]().close // Not compiling

  Door[Closed]().open
  Door[Open]().close
}
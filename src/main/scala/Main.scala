package sample

import akka.actor.{ ActorSystem, Props }
import sample.GetSpeed.Event

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getSpeed = system.actorOf(Props[GetSpeed], "getSpeed")

  getSpeed ! Event("40km/h", None)

  system.terminate()
}

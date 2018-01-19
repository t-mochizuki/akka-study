package sample

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getNumberPlate = system.actorOf(Props(classOf[GetNumberPlate], None), "getNumberPlate")
  val getTime = system.actorOf(Props(classOf[GetTime], Some(getNumberPlate)), "getTime")
  val getSpeed = system.actorOf(Props(classOf[GetSpeed], Some(getTime)), "getSpeed")

  val data = Data("40km/h", java.time.LocalDate.now, "な17-17")

  getSpeed ! Event(data, None)

  system.terminate()
}

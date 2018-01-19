package sample

import akka.actor.{ ActorSystem, Props }
import sample.GetSpeed.{ Event => GetSpeedEvent }
import sample.GetTime.{ Event => GetTimeEvent }
import sample.GetNumberPlate.{ Event => GetNumberPlateEvent }

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getSpeed = system.actorOf(Props[GetSpeed], "getSpeed")

  getSpeed ! GetSpeedEvent("40km/h", None)

  val getTime = system.actorOf(Props[GetTime], "getTime")

  getTime ! GetTimeEvent(java.time.LocalDate.now.toString, None)

  val getNumberPlate = system.actorOf(Props[GetNumberPlate], "getNumberPlate")

  getNumberPlate ! GetNumberPlateEvent("な17-17", None)

  system.terminate()
}

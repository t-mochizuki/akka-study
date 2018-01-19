package sample

import akka.actor.{ ActorSystem, Props }
import sample.GetSpeed.{ Event => GetSpeedEvent }
import sample.GetTime.{ Event => GetTimeEvent }
import sample.GetNumberPlate.{ Event => GetNumberPlateEvent }

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getSpeed = system.actorOf(Props[GetSpeed], "getSpeed")

  val data = Data("40km/h", java.time.LocalDate.now, "な17-17")

  getSpeed ! GetSpeedEvent(data, None)

  val getTime = system.actorOf(Props[GetTime], "getTime")

  getTime ! GetTimeEvent(data, None)

  val getNumberPlate = system.actorOf(Props[GetNumberPlate], "getNumberPlate")

  getNumberPlate ! GetNumberPlateEvent(data, None)

  system.terminate()
}

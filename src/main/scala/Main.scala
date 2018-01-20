package sample

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getNumberPlate = system.actorOf(Props[GetNumberPlate], "getNumberPlate")
  val getTime = system.actorOf(Props[GetTime], "getTime")
  val getSpeed = system.actorOf(Props[GetSpeed], "getSpeed")
  val supervisor = system.actorOf(Props(classOf[Supervisor], getSpeed, getTime, getNumberPlate), "supervisor")

  val data = Data("40km/h", java.time.LocalDate.now, "な17-17", 5) // 81 seconds
                                                                   // 81 = 1 + 15 * 5 + 5

  supervisor ! GetSpeedEvent(data, None)

  Thread.sleep(1000)

  system.terminate()
}

package sample

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  val system: ActorSystem = ActorSystem("traffic")

  val getNumberPlate = system.actorOf(Props[GetNumberPlate], "getNumberPlate")
  val getTime = system.actorOf(Props[GetTime], "getTime")
  val getSpeed = system.actorOf(Props[GetSpeed], "getSpeed")
  val supervisor = system.actorOf(Props(classOf[Supervisor], getSpeed, getTime, getNumberPlate), "supervisor")

  val data = Data("40km/h", java.time.LocalDate.now, "な17-17", 5) // 8.1 seconds
                                                                   // 8.1 = 0.1 + 1.5 * 5 + 0.5

  supervisor ! GetSpeedEvent(data, None)

  Thread.sleep(10000)

  system.terminate()
}

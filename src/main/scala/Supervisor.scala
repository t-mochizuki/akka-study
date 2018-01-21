package sample

import akka.actor.{Actor, ActorLogging, Props, Terminated}


class Supervisor extends Actor with ActorLogging {

  val getNumberPlate = context.actorOf(Props[GetNumberPlate], "getNumberPlate")
  context.watch(getNumberPlate)
  val getTime = context.actorOf(Props[GetTime], "getTime")
  context.watch(getTime)
  val getSpeed = context.actorOf(Props[GetSpeed], "getSpeed")
  context.watch(getSpeed)

  def receive = {
    case Terminated(actorRef) =>
      log.warning("Actor {} terminated", actorRef)
    case event: GetSpeedEvent => {
      if (event.data.count > 0) {
        log.info(s"Get Speed ${event.data.count}")
        getSpeed ! Event(event.data, None)
      }
    }
    case event: GetTimeEvent => {
      if (event.data.count > 0) {
        log.info(s"Get Time ${event.data.count}")
        getTime ! Event(event.data, None)
      }
    }
    case event: GetNumberPlateEvent => {
      if (event.data.count > 0) {
        log.info(s"Get NumberPlate ${event.data.count}")
        getNumberPlate ! Event(event.data, None)
      }
    }
  }
}

package sample

import akka.actor.{Actor, ActorLogging, ActorRef, Terminated}


class Supervisor(getSpeed: ActorRef, getTime: ActorRef, getNumberPlate: ActorRef) extends Actor with ActorLogging {

  context.watch(getSpeed)
  context.watch(getTime)
  context.watch(getNumberPlate)

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

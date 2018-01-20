package sample

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

class GetTime extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      sender ! GetSpeedEvent(event.data.copy(count = event.data.count - 1), None)
      // Thread.sleep(15000)
      log.info(s"GetTime: ${event.data.time}")
      sender ! GetNumberPlateEvent(event.data, None)
      event.optionActorRef.foreach(_ ! event.data.time)
  }
}

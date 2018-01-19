package sample

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

class GetTime(optionNext: Option[ActorRef]) extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      log.info(s"GetTime: ${event.data.time}")
      optionNext.foreach(_ ! event)
      event.optionActorRef.foreach(_ ! event.data.time)
  }
}

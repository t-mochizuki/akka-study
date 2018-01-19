package sample

import akka.actor.{Actor, ActorLogging, ActorRef}

class GetSpeed(optionNext: Option[ActorRef]) extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      log.info(s"GetSpeed: ${event.data.speed}")
      optionNext.foreach(_ ! event)
      event.optionActorRef.foreach(_ ! event.data.speed)
  }
}

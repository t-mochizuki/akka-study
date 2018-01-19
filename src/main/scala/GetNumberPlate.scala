package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

class GetNumberPlate(optionNext: Option[ActorRef]) extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      log.info(s"GetNumberPlate: ${event.data.numberPlate}")
      optionNext.foreach(_ ! event)
      event.optionActorRef.foreach(_ ! event.data.numberPlate)
  }
}

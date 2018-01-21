package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

class GetNumberPlate extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      Thread.sleep(500)
      log.info(s"GetNumberPlate: ${event.data.numberPlate}")
      event.optionActorRef.foreach(_ ! event.data.numberPlate)
  }
}

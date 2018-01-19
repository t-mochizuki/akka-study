package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetNumberPlate {
  case class Event(data: Data, optionActorRef: Option[ActorRef])
}

class GetNumberPlate extends Actor with ActorLogging {
  import GetNumberPlate._

  def receive = {
    case event: Event =>
      log.info(s"GetNumberPlate: ${event.data.numberPlate}")
      event.optionActorRef.foreach {
        _ ! event.data.numberPlate
      }
  }
}

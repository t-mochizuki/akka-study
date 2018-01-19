package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetNumberPlate {
  case class Event(msg: String, optionActorRef: Option[ActorRef])
}

class GetNumberPlate extends Actor with ActorLogging {
  import GetNumberPlate._

  def receive = {
    case event: Event =>
      log.info(s"GetNumberPlate: ${event.msg}")
      event.optionActorRef.foreach {
        _ ! event.msg
      }
  }
}

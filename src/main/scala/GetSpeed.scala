package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetSpeed {
  case class Event(msg: String, optionActorRef: Option[ActorRef])
}

class GetSpeed extends Actor with ActorLogging {
  import GetSpeed._

  def receive = {
    case event: Event =>
      log.info(s"GetSpeed: ${event.msg}")
      event.optionActorRef.foreach {
        _ ! event.msg
      }
  }
}

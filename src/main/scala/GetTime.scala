package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetTime {
  case class Event(msg: String, optionActorRef: Option[ActorRef])
}

class GetTime extends Actor with ActorLogging {
  import GetTime._

  def receive = {
    case event: Event =>
      log.info(s"GetTime: ${event.msg}")
      event.optionActorRef.foreach {
        _ ! event.msg
      }
  }
}

package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetTime {
  case class Event(data: Data, optionActorRef: Option[ActorRef])
}

class GetTime extends Actor with ActorLogging {
  import GetTime._

  def receive = {
    case event: Event =>
      log.info(s"GetTime: ${event.data.time}")
      event.optionActorRef.foreach {
        _ ! event.data.time
      }
  }
}

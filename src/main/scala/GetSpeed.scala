package sample

import akka.actor.{ Actor, ActorLogging, ActorRef }

object GetSpeed {
  case class Event(data: Data, optionActorRef: Option[ActorRef])
}

class GetSpeed extends Actor with ActorLogging {
  import GetSpeed._

  def receive = {
    case event: Event =>
      log.info(s"GetSpeed: ${event.data.speed}")
      event.optionActorRef.foreach {
        _ ! event.data.speed
      }
  }
}

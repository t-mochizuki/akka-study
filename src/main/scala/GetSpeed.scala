package sample

import akka.actor.{Actor, ActorLogging}

class GetSpeed extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      Thread.sleep(100)
      log.info(s"GetSpeed: ${event.data.speed}")
      sender ! GetTimeEvent(event.data, None)
      event.optionActorRef.foreach(_ ! event.data.speed)
  }
}

package sample

import akka.actor.{Actor, ActorLogging, ActorRef}

class GetSpeed extends Actor with ActorLogging {

  def receive = {
    case event: Event =>
      // Thread.sleep(1000)
      log.info(s"GetSpeed: ${event.data.speed}")
      sender ! GetTimeEvent(event.data, None)
      event.optionActorRef.foreach(_ ! event.data.speed)
  }
}

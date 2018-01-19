package sample

import akka.actor.ActorRef

case class Event(data: Data, optionActorRef: Option[ActorRef])

package sample

import akka.actor.ActorRef

case class Event(data: Data, optionActorRef: Option[ActorRef])
case class GetSpeedEvent(data: Data, optionActorRef: Option[ActorRef])
case class GetTimeEvent(data: Data, optionActorRef: Option[ActorRef])
case class GetNumberPlateEvent(data: Data, optionActorRef: Option[ActorRef])

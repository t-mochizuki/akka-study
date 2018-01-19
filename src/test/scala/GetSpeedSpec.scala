package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, WordSpecLike }
import sample.GetSpeed.Event

class GetSpeedSpec extends TestKit(ActorSystem("testsystem"))
  with WordSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "GetSpeed" must {
    "be 40km/h" in {
      val actor = system.actorOf(Props[GetSpeed])
      actor ! Event("40km/h", Some(testActor))
      expectMsg("40km/h")
    }
  }
}

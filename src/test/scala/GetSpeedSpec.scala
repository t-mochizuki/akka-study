package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }
import sample.GetSpeed.Event

class GetSpeedSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetSpeed") {
    it("should be 40km/h") {
      val actor = system.actorOf(Props[GetSpeed])
      actor ! Event("40km/h", Some(testActor))
      expectMsg("40km/h")
    }
  }
}

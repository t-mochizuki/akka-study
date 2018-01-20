package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }

class GetSpeedSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetSpeed") {
    it("should be 40km/h") {
      val actor = system.actorOf(Props[GetSpeed])
      val data = Data("40km/h", java.time.LocalDate.now, "な17-17", 1)
      actor ! Event(data, Some(testActor))
      expectMsg("40km/h")
    }
  }
}

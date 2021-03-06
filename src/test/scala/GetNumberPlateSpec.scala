package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }

class GetNumberPlateSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetNumberPlate") {
    it("should be な17-17") {
      val actor = system.actorOf(Props[GetNumberPlate])
      val data = Data("40km/h", java.time.LocalDate.now, "な17-17", 1)
      actor ! Event(data, Some(testActor))
      expectMsg("な17-17")
    }
  }
}

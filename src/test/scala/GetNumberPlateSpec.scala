package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }
import sample.GetNumberPlate.Event

class GetNumberPlateSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetNumberPlate") {
    it("should be な17-17") {
      val actor = system.actorOf(Props[GetNumberPlate])
      actor ! Event("な17-17", Some(testActor))
      expectMsg("な17-17")
    }
  }
}

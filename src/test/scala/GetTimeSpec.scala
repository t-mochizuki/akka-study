package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }
import sample.GetTime.Event

class GetTimeSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetTime") {
    it("should be Now") {
      val actor = system.actorOf(Props[GetTime])
      val data = Data("40km/h", java.time.LocalDate.now, "な17-17")
      actor ! Event(data, Some(testActor))
      expectMsg(data.time)
    }
  }
}

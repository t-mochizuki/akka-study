package sample

import akka.actor.{ ActorSystem, Props }
import akka.testkit.TestKit
import java.time.LocalDate
import org.scalatest.{ BeforeAndAfterAll, FunSpecLike }
import sample.GetSpeed.Event

class GetTimeSpec extends TestKit(ActorSystem("testsystem"))
  with FunSpecLike
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  describe("GetTime") {
    it("should be Now") {
      val actor = system.actorOf(Props[GetSpeed])
      val msg = LocalDate.now.toString
      actor ! Event(msg, Some(testActor))
      expectMsg(msg)
    }
  }
}

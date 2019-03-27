import java.time.Duration

import RaceProtocol._
import akka.actor.{Actor, ActorLogging, ActorRef, Props, Timers}

import scala.collection.immutable.ListMap
import scala.collection.mutable

class RaceControlActor(raceLength: Int)
  extends Actor
    with ActorLogging
    with Timers {

  timers.startPeriodicTimer(s"race-timer",
    ReportProgress,
    Duration.ofSeconds(1))

  private[this] val progresses = mutable.HashMap.empty[ActorRef, Int]
  private[this] val carsInfo = mutable.HashMap.empty[ActorRef, String]
  private[this] val cars = mutable.ListBuffer.empty[ActorRef]

  override def receive: Receive = idle

  val idle: Receive = {
    case SignMeUp(car, name) => {
      cars += car
      progresses.put(car, 0)
      carsInfo.put(car, name)
    }
    case StartRace => context.become(running)
  }

  val running: Receive = {
    case Progress(car, increments, decrements) => {

    }
    case ReportProgress => {

    }
  }

}

object RaceControlActor {
  def props(raceLength: Int): Props =
    Props(new RaceControlActor(raceLength))
}

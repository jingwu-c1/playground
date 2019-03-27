import RaceProtocol._
import akka.actor.{Actor, ActorRef, Props}


class CarActor(raceControl: ActorRef, name: String) extends Actor {

  override def preStart(): Unit = {
    super.preStart()
  }

  override def receive: Receive = {
    case ReportProgress => _
  }
}

object CarActor {
  def props(raceControl: ActorRef, name: String): Props =
    Props(new CarActor(raceControl, name))
}

import akka.actor.ActorRef

object RaceProtocol {
  case object StartRace
  case class SignMeUp(actor: ActorRef, name: String)
  case object ReportProgress
  case class Progress(actor: ActorRef, increments: Int, decrements: Int)
}

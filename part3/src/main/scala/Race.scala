import RaceProtocol.StartRace
import akka.actor.{ActorSystem, Props}

object Race {

  /**
    * RaceControlActor has mutable not thread-safe internal state(s) tracking all car's positions
    * Every second, RaceControlActor will ask CarActor about its progress. CarActor (i.e. CarActor1) will return the progress with 2 value (randomly generated int smaller than 10): increments (int) and decrements (int)
    *      Increments: RaceControlActor increase that car's (CarActor1) position by the increment in its internal state.
    *      Decrements: RaceControlActor decrease the car right behind CarActor1's position by the decrement in its internal state. (right behind means the car with the highest progress smaller than CarActor1's progress)
    *
    * Once there is a car reached 100, race is over and each car's position will be printed out.
    *
    */
  def main(args: Array[String]): Unit = {
    val actorSystem: ActorSystem = ActorSystem("race")

    val raceControlActor = actorSystem.actorOf(
      Props(clazz = classOf[RaceControlActor], 100),
      "control"
    )

    (1 to 9) foreach (x => {
      actorSystem.actorOf(
        Props(clazz = classOf[CarActor], raceControlActor, s"car $x"),
        s"car$x"
      )
    })

    raceControlActor ! StartRace
  }

}

package com.hansblackcatnas

import akka.actor.{Actor, ActorLogging, ActorSystem, PoisonPill, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import concurrent.duration._
import scala.concurrent.Future

object Main extends App {
  implicit val timeout = Timeout(5 second)

  val system = ActorSystem("DonutStoreActorSystem")
  object DonutStoreProtocol {
    case class Information(name: String)
    case class CheckStock(name: String)
    case class WorkerFailedException(error: String) extends Exception(error)
  }
  import DonutStoreProtocol._

  //  Ask Pattern
  //  println("Step 1: Create an actor system")
  //  val system2 = ActorSystem("DonutStoreActorSystem")
  //
  //  println("\nStep 2: Define the message passing protocol for our DonutStoreActor")
  //  object DonutStoreProtocol {
  //    case class Info(name: String)
  //  }
  //
  //  println("\nStep 3: Create DonutInfoActor")
  //  class DonutInfoActor extends Actor with ActorLogging {
  //    import DonutStoreProtocol._
  //
  //    def receive: Receive = {
  //      case Info(name) if name == "Vanilla" => {
  //        log.info(s"Found valid $name donut")
  //        sender ! true
  //      }
  //
  //      case Info(name) => {
  //        log.info(s"$name donut is not supported")
  //        sender ! false
  //      }
  //    }
  //  }
  //
  //  println("\nStep 4: Create DonutInfoActor")
  //  val donutInfoActor = system2.actorOf(Props[DonutInfoActor], name = "vanilla")
  //
  //  println(s"\nStep 5: Akka ask pattern")
  //  implicit val timeout = Timeout(5 second)
  //  val vanillaDonutFound = donutInfoActor ? Info("Vanilla") // need implicit timeout
  //  for {
  //    found <- vanillaDonutFound
  //  } yield (println(s"Vanilla donut found = $found"))
  //
  //  val glazedDonutFound = donutInfoActor ? Info("Glazed")
  //  for {
  //    found <- glazedDonutFound
  //  } yield (println(s"Glazed donut not found = $found"))
  //
  //  println("\nStep 6: Close the actor system")
  //  val isTerminated = system2.terminate()
  //
  //
  //  // Ask Pattern mapTo
  //  println("\n<< Ask Pattern mapTo >>")
  //  val system3 = ActorSystem("DonutStoreActorSystem")
  //
  //  object DonutStoreProtocol3 {
  //    case class Info(name: String)
  //  }
  //
  //  class DonutInfoActor3 extends Actor with ActorLogging {
  //    import DonutStoreProtocol3._
  //
  //    override def receive: Receive = {
  //      case DonutStoreProtocol3.Info(name) if name == "Vanilla" => {
  //        log.info(s"Found valid $name donut")
  //        sender ! true
  //      }
  //
  //      case DonutStoreProtocol3.Info(name) => {
  //        log.info(s"%" +
  //          s"$name donut is not supported")
  //        sender ! false
  //      }
  //    }
  //  }
  //
  //  val donutInfoActor3 = system3.actorOf(Props[DonutInfoActor3], name = "Vanilla")
  //  val vanillaDonutFound3 = (donutInfoActor3 ? Info("Vanilla")).mapTo[Boolean]
  //  for {
  //    found <- vanillaDonutFound3
  //  } yield println(s"Vanilla donut found = $found")
  //  Thread.sleep(5000)
  //
  //  val isTerminated3 = system3.terminate()


  //  Ask Pattern pipeTo
  //  println(s"<< Ask Pattern pipeTo >>")
  //  val system4 = ActorSystem("DonutStoreActorSystem")
  //  object DonutStoreProtocol4 {
  //    case class Information(name: String)
  //    case class CheckStore(name: String)
  //  }
  //
  //  class DonutStockActor4 extends Actor with ActorLogging {
  //    import DonutStoreProtocol4._
  //
  //    def findStock(name: String): Future[Int] = Future {
  //      // some code
  //      100
  //    }
  //
  //    override def receive: Receive = {
  //      case CheckStore(name) => {
  //        log.info(s"Checking stock for $name donut")
  //        findStock(name).pipeTo(sender())
  //      }
  //    }
  //  }
  //
  //  val donutStockActor4 = system4.actorOf(Props[DonutStockActor4], name = "DonutStockActor")
  //  val vanillaDonutStock: Future[Int] = (donutStockActor4 ? CheckStore(name = "Vanilla")).mapTo[Int]
  //  for {
  //    found <- vanillaDonutStock
  //  } yield println(s"Vanilla donut stock = $found")
  //  Thread.sleep(5000)
  //
  //  val isTerminated4 = system4.terminate()

  //  Actor LookUp
  //  println("\n << Actor LookUp >>")
  //  val system5 = ActorSystem("DonutStoreActorSystem")
  //
  //  object DonutStoreProtocol5 {
  //    case class Information(name: String)
  //  }
  //  import DonutStoreProtocol5._
  //  class DonutInfoActor5 extends Actor with ActorLogging {
  //    override def receive: Receive = {
  //      case Information(name) => {
  //        log.info(s"Found $name donut")
  //      }
  //    }
  //  }
  //  val donutInfoActor5 = system5.actorOf(Props[DonutInfoActor5], name = "DonutInfoActor5")
  //  donutInfoActor5 ! Information("Vanilla")
  //  system5.actorSelection("/user/DonutInfoActor5") ! Information("Chocolate")
  //  system5.actorSelection("/user/*") ! Information("Mint")
  //
  //  Thread.sleep(5000)
  //  val isTerminated = system5.terminate()

  //  Child Actor
  //  println(s"<< Child Actor >>")
  //  val system6 = ActorSystem("DonutStoreActorSystem")
  //  object DonutStoreProtocol6 {
  //    case class Information(name: String)
  //  }
  //  import DonutStoreProtocol6._
  //
  //  class BakingActor6 extends Actor with ActorLogging {
  //    override def receive: Receive = {
  //      case Information(name) => {
  //        log.info(s"BackingActor baking $name donut")
  //      }
  //    }
  //  }
  //
  //  class DonutInfoActor6 extends Actor with ActorLogging {
  //    val bakingActor6 = context.actorOf(Props[BakingActor6], name = "BakingActor6")
  //
  //    override def receive: Receive = {
  //      case msg @ Information(name) => {
  //        log.info(s"Found $name donut")
  //        bakingActor6 forward msg
  //      }
  //    }
  //  }
  //
  //  val donutInfoActor6 = system6.actorOf(Props[DonutInfoActor6], name = "DonutInfoActor6")
  //  donutInfoActor6 ! Information("Vanilla")
  //
  //  Thread.sleep(3000)
  //  val isTerminated6 = system6.terminate()

  //  Actor LifeCycle
  //  val system7 = ActorSystem("DonutStoreActorSystem")
  //
  //  object DonutStoreProtocol7 {
  //
  //    case class Information(name: String)
  //
  //  }
  //
  //  import DonutStoreProtocol7._
  //
  //  class BakingActor7 extends Actor with ActorLogging {
  //    override def preStart(): Unit = log.info("preStart")
  //
  //    override def postStop(): Unit = log.info("postStop")
  //
  //    override def preRestart(reason: Throwable, message: Option[Any]): Unit = log.info("preRestart")
  //
  //    override def postRestart(reason: Throwable): Unit = log.info("postRestart")
  //
  //    override def receive: Receive = {
  //      case Information(name) => {
  //        log.info(s"BakingActor baking $name donut")
  //      }
  //    }
  //  }
  //
  //  class DonutInfoActor7 extends Actor with ActorLogging {
  //    override def preStart(): Unit = log.info("preStart")
  //
  //    override def postStop(): Unit = log.info("postStop")
  //
  //    override def preRestart(reason: Throwable, message: Option[Any]): Unit = log.info("preRestart")
  //
  //    override def postRestart(reason: Throwable): Unit = log.info("postRestart")
  //
  //    val bakingActor7 = context.actorOf(Props[BakingActor7], name = "BakingActor7")
  //    override def receive: Receive = {
  //      case msg @ Information(name) => {
  //        log.info(s"Found $name donut")
  //        bakingActor7 forward msg
  //      }
  //    }
  //  }
  //
  //  val donutInfoActor7 = system7.actorOf(Props[DonutInfoActor7], name = "DonutInfoActor7")
  //  donutInfoActor7 ! Information("Vanilla")
  //
  //  Thread.sleep(3000)
  //  val isTerminated7 = system7.terminate

  // Actor PoisonPill
//  val system8 = ActorSystem("DonutStoreActorSystem")
//  object DonutStoreProtocol8 {
//    case class Information(name: String)
//  }
//  import DonutStoreProtocol8._
//
//  class BakingActor8 extends Actor with ActorLogging {
//    override def preStart(): Unit = log.info("preStart")
//    override def postStop(): Unit = log.info("postStop")
//    override def preRestart(reason: Throwable, message: Option[Any]): Unit = log.info("preRestart")
//    override def postRestart(reason: Throwable): Unit = log.info("postRestart")
//
//    override def receive: Receive = {
//      case Information(name) => {
//        log.info(s"BakingActor baking $name actor")
//      }
//    }
//  }
//
//  class DonutInfoActor8 extends Actor with ActorLogging {
//    override def preStart(): Unit = log.info("preStart")
//    override def postStop(): Unit = log.info("postStop")
//    override def preRestart(reason: Throwable, message: Option[Any]): Unit = log.info("preRestart")
//    override def postRestart(reason: Throwable): Unit = log.info("postRestart")
//
//    val bakingActor8 = context.actorOf(Props[BakingActor8], name = "BakingActor8")
//    override def receive: Receive = {
//      case msg @ Information(name) => {
//        log.info(s"Found $name actor")
//        bakingActor8 forward msg;
//      }
//    }
//  }
//
//  val donutInfoActor8 = system8.actorOf(Props[DonutInfoActor8], name = "DonutInfoActor8")
//  donutInfoActor8 ! Information("Vanilla")
//  donutInfoActor8 ! PoisonPill
//  donutInfoActor8 ! Information("plain")
//
//  Thread.sleep(3000)
//  val isTerminated8 = system8.terminate()

  // Error Kernel Supervision





  Thread.sleep(3000)
  val isTerminated = system.terminate()
}



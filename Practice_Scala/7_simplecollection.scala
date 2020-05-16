import scala.collection.mutable
import scala.collection.immutable.HashSet

object main extends App {
    
    // <Tuple>
    
    val pair = (99, "FlyingMachine")
    val (p1,p2) = pair
    val fst = pair._1

    // <Set>

    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lufthansa"
    val set_fst = jetSet
    println(jetSet.contains("Lufthansa"))

    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet.+("Shrek")
    println(movieSet)

    val hashSets = HashSet("Tomatoes", "Chilies")
    println(hashSets)

    // <Map>

    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island")
    treasureMap += (2 -> "Dooooora")
    println(treasureMap(2))
}
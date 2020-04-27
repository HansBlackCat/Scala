trait TailWagger {
    def startTail(): Unit
    def stopTail(): Unit
}

trait Speaker {
    def speak(): String
}

trait Runner {
    def startRunning(): Unit
    def stopRunning(): Unit
}

trait Nom {
    def nom(): Unit = println("Nom always running")
    def nom2(p: String): Unit = println(s"${p} is chasing")
}

class Dog(val dogName: String = "Nu-rung") extends TailWagger with Speaker with Runner with Nom{
    def startTail(): Unit = println("tail is wagging")
    def stopTail(): Unit = println("tail is stopped")

    def speak(): String = "Woof!"

    def startRunning(): Unit = println("I'm running")
    def stopRunning(): Unit = println("Stopped running")

    def callNom2(): Unit = nom2(dogName)

    override def nom(): Unit = println("Yo You Man")
}

abstract class Pet (name: String) {
    def speak(): Unit = println(s"My name is ${name}")
    def comeToMaster(): Unit
}

class Doggy(name: String) extends Pet(name) {
    override def speak(): Unit = println("Woof")
    def comeToMaster(): Unit = println("Wang")
}

class SmartDoggy(name: String) extends Pet(name) {
    def comeToMaster(): Unit = println("Hi")
}
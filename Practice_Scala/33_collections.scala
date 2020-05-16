
import scala.util.Random

// append and prepend at const speed at average
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

// import Predef.Set
import scala.collection.mutable

import scala.collection.immutable.{TreeMap, TreeSet}

// Predefed: LazyList

object main {
    val buf = new ListBuffer[Int]
    buf += 1
    buf += 2
    buf += 10 // append
    30 +=: buf // prepend
    buf.toList

    val bufA = new ArrayBuffer[Int]
    bufA += 12
    19 +=: bufA

    val mSet = mutable.Set(1,2,3)
    val text = "See Spot run, Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")

    val emS = mutable.Set.empty[String]
    for (word <- wordsArray) {
        emS += word.toLowerCase()
    }

    val map = mutable.Map.empty[String, Int]
    map("hello") = 1
    map("there") = 2

    def countWords(text: String) = {
        import scala.collection.mutable
        val counts = mutable.Map.empty[String, Int]
        for (rawWord <- text.split("[ ,.!?]+")) {
            val word = rawWord.toLowerCase
            val oldCount = {
                if (counts.contains(word)) counts(word)
                else 0
            }
            counts += (word -> (oldCount + 1))
        }
        counts
    }

    def countWords2(text: String) = {
        import scala.collection.mutable
        val counts = mutable.Map.empty[String, Int]
        for (rawWord <- text.toLowerCase.split("[ ,.!?]+")) {
            if (counts.contains(rawWord)) counts(rawWord) += 1
            else counts(rawWord)=1
        }
        counts
    }

    val randomInit_NoSeed = Random
    val rl = {
        for (i <- 0 until 10) yield randomInit_NoSeed.nextInt(100)
    }

    val ts = mutable.TreeSet.empty[Int]
    for (elem <- rl) ts += elem 

    val ts2 = rl.toList.to(TreeSet)

    // `var` syntax sugar for immut collections
    var people = Set("Nancy", "Jane")
    people += "Bob"

    

}

package dev.mlScala.source

/*
 * type Features = Array[Double]
 * type Weight = Array[Double]
 * type ObsSet = Vector[Features]
 * type Fields = Array[String]
 */

object GoogleFinancials extends Enumeration {
    import dev.mlScala.FinanceType._

    type GoogleFinancials = Value
    val DATE, OPEN, HIGH, LOW, CLOSE, VOLUME, ADJ_CLOSE = Value
    
    def toDouble(v: Value): Fields => Double = {
        (s: Fields) => s(v.id).toDouble
    }
    def toArray(vs: Array[Value]): Fields => Features = {
        (s: Fields) => vs.map(v => s(v.id).toDouble)
    }
}
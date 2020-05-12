package dev.mlScala.source

import scala.util.Try
import scala.io.Source

/*
 * type Features = Array[Double]
 * type Weight = Array[Double]
 * type ObsSet = Vector[Features]
 * type Fields = Array[String]
 */

object GoogleFinancials extends Enumeration {
    import dev.mlScala.DataType._
    import dev.mlScala.FinanceType._

    type GoogleFinancials = Value
    val DATE, OPEN, HIGH, LOW, CLOSE, VOLUME, ADJ_CLOSE = Value
    
    def toDouble(v: Value): Fields => Double = {
        (s: Fields) => s(v.id).toDouble
    }
    def toArray(vs: Array[Value]): Fields => Features = {
        (s: Fields) => vs.map(v => s(v.id).toDouble)
    }
    /*
    def load(fileName: String): Try[Vector[DblPair]] = Try {
        val src = Source.fromFile(fileName)
        val data = extract(src.getLines.map(_.split(",")).drop(1))
        src.close
        data
    } */   
    def extract(cols: Iterator[Fields]): ObsSet = {
        val features = Array[GoogleFinancials](LOW, HIGH, VOLUME)
        val conversion = toArray(features)
        cols.map(conversion(_)).toVector
            .map(x => Array[Double](1.0 - x(0)/x(1), x(2)))
    }
}
package dev.mlScala

import scala.util.Try

package object FinanceType {
    type Features = Array[Double]
    type Weight = Array[Double]
    type ObsSet = Vector[Features]
    type Fields = Array[String]
}

package object DataType {
    type DblPair = (Double, Double)
    type DblArray = Array[Double]
    type DblMatrix = Array[DblArray]
    type Xseries[T] = Vector[T]
    type XVSeries[T] = Vector[Array[T]]

}
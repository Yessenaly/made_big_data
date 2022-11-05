package main

import breeze.linalg.DenseVector
import breeze.numerics.abs

class Metrics {

  def mse(yTrue: DenseVector[Double], yPred: DenseVector[Double]) = {
    ((yTrue - yPred) * (yTrue - yPred)).reduce(_ + _)
  }

  def mape(yTrue: DenseVector[Double], yPred: DenseVector[Double]) = {
    abs(yTrue - yPred).reduce(_ + _)
  }
}

package main

import breeze.linalg.{DenseMatrix, DenseVector, inv}

class LinearRegression {
  var w = DenseVector[Double]()

  def fit(x: DenseMatrix[Double], y: DenseVector[Double]) = {
    w = inv(x.t * x) * x.t * y
  }

  def predict(x: DenseMatrix[Double]): DenseVector[Double] = {
    x.toDenseMatrix * w.toDenseVector
  }
}

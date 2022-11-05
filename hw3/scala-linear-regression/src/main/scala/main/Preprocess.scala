package main

import java.io.File
import breeze.linalg.{DenseMatrix, csvread, csvwrite}

class Preprocess {

  def readCSV(filePath: String): DenseMatrix[Double] = {
    val df = csvread(file = new File(filePath), separator = ',', skipLines = 1)
    df
  }

  def toCSV(df: DenseMatrix[Double], filePath: String) = {
    csvwrite(file = new File(filePath), mat = df, separator = ',')
  }

  def split(df: DenseMatrix[Double], splitSize: Double) = {
    val total = df.rows
    val nRows = (total * (1 - splitSize)).toInt
    (df(0 to nRows - 1, ::), df(nRows to total - 1, ::))
  }

  def getXY(df: DenseMatrix[Double]) = {
    (df(::, 0 to df.cols - 1), df(::, -1))
  }
}

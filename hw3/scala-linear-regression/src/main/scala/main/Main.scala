package main

object Main {
  def main(args: Array[String]): Unit = {
    val preprocess = new Preprocess
    val df = preprocess.readCSV(filePath = "data/train.csv")
    val test = preprocess.readCSV(filePath = "data/test.csv")
    val (train, validation) = preprocess.split(df = df, splitSize = 0.2)
    val (xTrain, yTrain) = preprocess.getXY(train)
    val (xVal, yVal) = preprocess.getXY(validation)
    val (xTest, yTest) = preprocess.getXY(test)

    val model = new LinearRegression()
    model.fit(x = xTrain, y = yTrain)
    val predVal = model.predict(x = xVal)
    val predTest = model.predict(x = xTest)

    val metrics = new Metrics
    val mseVal = metrics.mse(yTrue = yVal, yPred = predVal)
    val mapeVal = metrics.mape(yTrue = yVal, yPred = predVal)
    println("MSE on validation: %f", mseVal)
    println("MAPE on validation: %f", mapeVal)
    preprocess.toCSV(filePath = "results/prediction.csv", df = predTest.toDenseMatrix.t)
  }
}
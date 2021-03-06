package ar.com.mbasilico.wordCounter

import scala.io.Source
import scala.collection.mutable.HashMap

object WordCounterSeqApp extends App {
  
  val TOP_WORD_LIMIT = 70

  def printTopWords(wordCounter: HashMap[String, Int]): Unit = {
    println("printTopWords STARTED. wordCounter: " + wordCounter)
    wordCounter.toList.filter{_._2  > TOP_WORD_LIMIT}.sortWith{_._2 > _._2}.foreach(tuple => println(tuple._1 + ": " + tuple._2))
  }

  val wordCounter = new HashMap[String, Int]()
  val fileName = args(0)

  try {
    for (line <- Source.fromFile(fileName)("UTF-8").getLines()) {
      LineWordCounterWorker.countWordsFP(wordCounter, line)
    }
    printTopWords(wordCounter)

    println("FINISHED")
  } catch {
    case ex: Exception => ex.printStackTrace()
  }

}
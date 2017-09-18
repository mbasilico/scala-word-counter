package ar.com.mbasilico.wordCounter

import scala.collection.mutable.HashMap

object LineWordCounterWorker {

  val TOP_WORD_LEN = 4

  def countWords(wordCount: HashMap[String, Int], line: String): Unit = {
    val words = line.split(" ")
    for (currentWord <- words) {
      val lowerCaseWord = currentWord.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]+", "")
      if (lowerCaseWord.length() > TOP_WORD_LEN) {
        if (wordCount.contains(lowerCaseWord)) {
          val currentCount = wordCount.get(lowerCaseWord).get
          wordCount.put(lowerCaseWord, currentCount + 1)
        } else {
          wordCount.put(lowerCaseWord, 1)
        }
      }
    }
  }

  def countWordsFP(wordCount: HashMap[String, Int], line: String): Unit = {
    val words = line.split(" ")
    words.map { _.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]+", "") }
      .filter { _.length > TOP_WORD_LEN }
      .foreach(word =>
        if (wordCount.contains(word)) {
          val currentCount = wordCount.get(word).get
          wordCount.put(word, currentCount + 1)
        } else wordCount.put(word, 1))
  }
}
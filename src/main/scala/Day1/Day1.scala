package Day1

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}
import scala.io.Source

object Day1 {

  val input: String = Files.readString(Path.of("src/main/scala/Day1/Day1Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList

  def getNumbers(input: String): List[Int] = {
    val numbers = List(0,1,2,3,4,5,6,7,8,9)

    val numbersAsListOfStrings = numbers.map(_.toString)
    val inputAsListOfStrings = input.toList.map(_.toString)

    val res = inputAsListOfStrings.filter(numbersAsListOfStrings.contains(_))

    res.map(_.toInt)
  }

  def getFirstAndLastNumbers(input: String): Int = {
    val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    val numbersAsListOfStrings = numbers.map(_.toString)
    val inputAsListOfStrings = input.toList.map(_.toString)

    val res = inputAsListOfStrings.filter(numbersAsListOfStrings.contains(_))
    val concatenated = res.head + res.last
    val answer = concatenated.toInt

    answer
  }

  def getDay1Answer(input:List[String]): Int = {

    val firstAndLasts = input.map(getFirstAndLastNumbers)
    println("tail: " + firstAndLasts.last + " ** " + firstAndLasts.length)
    firstAndLasts.sum
  }



}


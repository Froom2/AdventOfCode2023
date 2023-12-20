package Day1

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}

object Day1pt2 {

  val input: String = Files.readString(Path.of("src/main/scala/Day1/Day1Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList

//  def getNumbers(input: String): List[Int] = {
//    val numbers = List(0,1,2,3,4,5,6,7,8,9)
//
//    val numbersAsListOfStrings = numbers.map(_.toString)
//    val inputAsListOfStrings = input.toList.map(_.toString)
//
//    val res = inputAsListOfStrings.filter(numbersAsListOfStrings.contains(_))
//
//    res.map(_.toInt)
//  }

  def getStringNumbers(input: String) = {
    val stringNumbers = List(
      "ten" -> "t10n",
      "eleven" -> "e11n",
      "twelve" -> "t12e",
      "thirteen" -> "t13n",
      "fourteen" -> "f14n",
      "fifteen" -> "f15n",
      "sixteen" -> "s16n",
      "zero"  -> "z0o",
      "one"   -> "o1e",
      "two"   -> "t2o",
      "three" -> "t3e",
      "four"  -> "f4r",
      "five"  -> "f5e",
      "six"   -> "s6x",
      "seven" -> "s7n",
      "eight" -> "e8t",
      "nine"  -> "n9e"

    )

    stringNumbers.foldLeft(input)((a, b) => a.replaceAll(b._1, b._2))

  }

  def getFirstAndLastNumbers(input: String): Int = {
    val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    val numbersAsListOfStrings = numbers.map(_.toString)

    val withReplacedTextNumbers = getStringNumbers(input)

    val listthing = withReplacedTextNumbers.toList.map(_.toString)


//    println(listthing)

    val res = listthing.filter(numbersAsListOfStrings.contains(_))
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


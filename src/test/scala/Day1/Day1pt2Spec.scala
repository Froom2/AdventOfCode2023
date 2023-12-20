package Day1

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}

class Day1pt2Spec extends AnyFreeSpec {

  "On day 1" - {
    "it should read the input in correctly" - {
      "and have the right number of inputs" in {
        Day1pt2.trimmedList.size must be(1000)
      }
    }

    "getStringNumbers should replace the numbers written as strings" - {
      "when it is a single number" in {
        Day1pt2.getStringNumbers("aboneab") must be("ab1ab")
        Day1pt2.getStringNumbers("datwoas") must be("da2as")
      }
      "when there are multiple written numbers" in {
        Day1pt2.getStringNumbers("datwoasthree") must be("da2as3")
      }
    }

    "getFirstAndLastNumbers" - {
      "should get only the number on it's own if there is only one number" in {
        Day1pt2.getFirstAndLastNumbers("4") must be(44)
      }
      "should get only the first and last number in the list" in {
        Day1pt2.getFirstAndLastNumbers("1234") must be(14)
      }
      "should get only the first and last number in the list when there are text numbers" in {
        Day1pt2.getFirstAndLastNumbers("1234five") must be(15)
      }
    }
    "getDay1Answer" - {
      "should get the answer for the day" in {

        val testInput = List(
          "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
        "7pqrstsixteen"
        )
        Day1pt2.getDay1Answer(testInput) must be(281)
        Day1pt2.getDay1Answer(Day1pt2.trimmedList) must be(1000)
      }
    }
  }
}
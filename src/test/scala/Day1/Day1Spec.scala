package Day1

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}

class Day1Spec extends AnyFreeSpec {

  "On day 1" - {
    "it should read the input in correctly" - {
      "and have the right number of inputs" in {
        Day1.trimmedList.size must be(1000)
      }
    }
    "getNumbers should pull the numbers out of the string" - {
      "when there are no numbers" in {
        Day1.getNumbers("abc") must be(List())
      }
      "when given single number in string" in {
        Day1.getNumbers("1") must be(List(1))
      }
      "when given two numbers in string" in {
        Day1.getNumbers("12") must be(List(12))
      }
      "when given two numbers in a mixed char string" in {
        Day1.getNumbers("1rt2ab") must be(List(12))
      }
    }
    "getFirstAndLastNumbers" - {
      "should get only the number on it's own if there is only one number" in {
        Day1.getFirstAndLastNumbers("4") must be(44)
      }
      "should get only the first and last number in the list" in {
        Day1.getFirstAndLastNumbers("1234") must be(14)
      }
    }
    "getDay1Answer" - {
      "should get the answer for the day" in {

        val testInput = List(
          "1abc2", //12
            "pqr3stu8vwx", //11
            "a1b2c3d4e5f", //6
            "treb7uchet" //77 =
        )
        Day1.getDay1Answer(testInput) must be(142)
        Day1.getDay1Answer(Day1.trimmedList) must be(1000)
      }
    }
  }
}
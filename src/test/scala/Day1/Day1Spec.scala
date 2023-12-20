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
  }
}
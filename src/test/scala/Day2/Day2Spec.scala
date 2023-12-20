package Day2

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}

import Day2._

class Day2Spec extends AnyFreeSpec {

  "On day 2" - {
    "it should read the input in correctly" - {
      "and have the right number of inputs" in {
        println(Day2.trimmedList.head)
        Day2.trimmedList.size must be(100)
      }
      "and turn it into a better structure" in {
        val testData = List(
          "Game1: 3 blue, 4 red;1 red, 2 green, 6 blue;2 green",
          "Game2: 1 blue, 2 green;3 green, 4 blue, 1 red;1 green, 1 blue",
          "Game3: 8 green, 6 blue, 20 red;5 blue, 4 red, 13 green;5 green, 1 red",
          "Game4: 1 green, 3 red, 6 blue;3 green, 6 red;3 green, 15 blue, 14 red",
          "Game5: 6 red, 1 blue, 3 green;2 blue, 1 red, 2 green"
        )

        Day2.makeCubeSet("3 blue, 4 red") must be(CubeSet(3,4,0))

        Day2.makeGame("Game1: 3 blue, 4 red;1 red, 2 green, 6 blue;2 green") must be(
          Game(1, List(CubeSet(3,4,0), CubeSet(6,1,2), CubeSet(0,0,2)))
        )
      }
    }

    "it should "
  }

}
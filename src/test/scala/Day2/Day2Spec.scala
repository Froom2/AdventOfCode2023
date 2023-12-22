package Day2

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers.{be, convertToAnyMustWrapper}

import Day2._

class Day2Spec extends AnyFreeSpec {

  "On day 2" - {
    "it should read the input in correctly" - {
      "and have the right number of inputs" in {
        println(trimmedList.head)
        trimmedList.size must be(100)
      }
      "and turn it into a better structure" in {

//        makeCubeSet("3 blue, 4 red") must be(CubeSet(3,4,0))
//
//        makeGame("Game 1: 3 blue, 4 red;1 red, 2 green, 6 blue;2 green") must be(
//          Game(1, List(CubeSet(3,4,0), CubeSet(6,1,2), CubeSet(0,0,2)))
//        )
        makeGame("Game 91: 3 red, 1 green; 14 red, 2 blue, 2 green; 7 red, 3 blue; 1 blue, 6 red") must be(
          Game(91, List(CubeSet(0,3,1),CubeSet(2,14,2),CubeSet(3,7,0),CubeSet(1,6,0)))
        )
      }
    }

    "it should tell if a game is possible" in {

      val bagCubes = CubeSet(14, 12, 13)
      val gameToTest = Game(1, List(CubeSet(3,4,0), CubeSet(6,1,2), CubeSet(0,0,2)))

      gamepossible(bagCubes, gameToTest) must be(true)

      val gameToTest2 = makeGame("Game 3: 8 green, 6 blue, 20 red;5 blue, 4 red, 13 green;5 green, 1 red")
      gamepossible(bagCubes, gameToTest2) must be(false)

      val gameToTest3 = Game(1, List(CubeSet(14,12,13)))
      gamepossible(bagCubes, gameToTest3) must be(true)

      val gameToTest4 = Game(1, List(CubeSet(14, 20, 13)))
      gamepossible(bagCubes, gameToTest4) must be(false)

      val gameToTest5 = Game(1, List(CubeSet(14, 12, 20)))
      gamepossible(bagCubes, gameToTest5) must be(false)

      val gameToTest6 = Game(1, List(CubeSet(20, 12, 13)))
      gamepossible(bagCubes, gameToTest6) must be(false)
    }

    "it should get the Day 2 answer" in {
      val testData = List(
        "Game 1: 3 blue, 4 red;1 red, 2 green, 6 blue;2 green",
        "Game 2: 1 blue, 2 green;3 green, 4 blue, 1 red;1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red;5 blue, 4 red, 13 green;5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue;3 green, 6 red;3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green;2 blue, 1 red, 2 green"
      )
      val bagCubes = CubeSet(14, 12, 13)

      getDay2Answer(testData, bagCubes) must be(8)

      getDay2Answer(trimmedList, bagCubes) must be(2076)

    }

    "Part 2 should" - {
      "get the min number of cubes needed for all the games to be possible" in {
        val testData = List(
          "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
          "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
          "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
          "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
          "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )

        Day2Pt2.gameMins(testData) must be(
          List(
            CubeSet(6,4,2),
            CubeSet(4,1,3),
            CubeSet(6,20,13),
            CubeSet(15,14,3),
            CubeSet(2,6,3)
          )
        )
      }
      "get the powers of each cubeset" in {
        val testData = List(
          CubeSet(6, 4, 2),
          CubeSet(4, 1, 3),
          CubeSet(6, 20, 13),
          CubeSet(15, 14, 3),
          CubeSet(2, 6, 3)
        )
        Day2Pt2.getPowers(testData) must be(List(48,12, 1560, 630, 36))
      }
    }
  }

}
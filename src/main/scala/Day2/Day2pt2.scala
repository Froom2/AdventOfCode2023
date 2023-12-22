package Day2

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}

object Day2Pt2 {

  val input: String = Files.readString(Path.of("src/main/scala/Day2/Day2Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList


  case class Game(id: Int, cubeSets: List[CubeSet])

  case class CubeSet(blue: Int, red: Int, green: Int)

  def makeGame(string: String): Game = {

    val test = "Game 91: 3 red, 1 green; 14 red, 2 blue, 2 green; 7 red, 3 blue; 1 blue, 6 red"
    val split1 = string.split(": ")

    val gameId = split1.head.substring(5).toInt

    val sets = split1.last.split("; ")

    val cubeSets = sets.map(makeCubeSet).toList
    Game(gameId, cubeSets)
  }

  def makeCubeSet(string: String): CubeSet = {
    val splitString = string.split(", ")

    def getCubeNumber(colour: String): Int = {
      val pt1 = splitString.map(t => {
        t.split(" ")
      })
      val thingy = pt1.map(cube => {
        if (cube.tail.head == colour) cube.head.toInt else 0
      })
      thingy.toList.sum
    }

    val red = getCubeNumber("red")
    val blue = getCubeNumber("blue")
    val green = getCubeNumber("green")

    CubeSet(blue, red, green)
  }

  def gamepossible(bagCubes: CubeSet, game:Game): Boolean = {
    val listOfSets = game.cubeSets
    val setsPossible = listOfSets.map(set => {
      val greenPossible = bagCubes.green >= set.green
      val redPossible = bagCubes.red >= set.red
      val bluePossible = bagCubes.blue >= set.blue

      greenPossible & redPossible & bluePossible
    })

    !setsPossible.contains(false)
  }

  def getDay2Answer(input: List[String], bagCubes: CubeSet): Int = {
    val listOfGames = input.map(makeGame)
    val filteredGamesPossible = listOfGames.filter(gamepossible(bagCubes, _))

    val sumOfIds = filteredGamesPossible.map(_.id).sum
    sumOfIds
  }

  def gameMins(input: List[String]): List[CubeSet] = {

    val listOfGames = input.map(makeGame)

    listOfGames.map(game =>{
    val redMax = game.cubeSets.map(cs => cs.red).max
      val blueMax = game.cubeSets.map(cs => cs.blue).max
      val greenMax = game.cubeSets.map(cs => cs.green).max

      CubeSet(blueMax, redMax, greenMax)
    })

  }

}

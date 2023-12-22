package Day2

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}

object Day2 {

  val input: String = Files.readString(Path.of("src/main/scala/Day2/Day2Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList


  case class Game(id: Int, cubeSets: List[CubeSet])

  case class CubeSet(blue: Int, red: Int, green: Int)

  def makeGame(string: String): Game = {

    val test = "Game 91: 3 red, 1 green; 14 red, 2 blue, 2 green; 7 red, 3 blue; 1 blue, 6 red"
    val split1 = string.split(": ")
    val splitTest = test.split(": ").toList
    splitTest.foreach(println)

    val gameId = split1.head.substring(5).toInt
    val gameIdTest = splitTest.head.substring(5).toInt
    println(gameIdTest)

    val sets = split1.last.split("; ")
    val setsTest = splitTest.last.split(";")
    setsTest.foreach(println)

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
    val listOfGamesPossible = listOfGames.map(gamepossible(bagCubes, _))
//    listOfGamesPossible.foreach(println)

    println("**** game 91: " + listOfGames(90))

    println(makeGame("Game 91: 3 red, 1 green; 14 red, 2 blue, 2 green; 7 red, 3 blue; 1 blue, 6 red"))

    val filteredGamesPossible = listOfGames.filter(gamepossible(bagCubes, _))

    val gamesNotPossible = listOfGames.filter(!gamepossible(bagCubes,_))

    val redpossiblemax = filteredGamesPossible.map(g => {
      val allRedInGame = g.cubeSets.map(
        c => {
          c.red
        }
      )
      allRedInGame.max
    })
    println("&&&&& RED " + redpossiblemax.max)

    val greenpossiblemax = filteredGamesPossible.map(g => {
      val allGreenInGame = g.cubeSets.map(
        c => {
          c.green
        }
      )
      allGreenInGame.max
    })
    println("&&&&& GREEN " + greenpossiblemax.max)

    val bluepossiblemax = filteredGamesPossible.map(g => {
      val allBlueInGame = g.cubeSets.map(
        c => {
          c.blue
        }
      )
      allBlueInGame.max
    })
    println("&&&&& BLUE " + bluepossiblemax.max)

    println("***IDs " + filteredGamesPossible.map(_.id))
    println("***IDs length " + filteredGamesPossible.length)

    println("&&& NOT POSSIBLE: " + gamesNotPossible.map(_.id))
    println("***NOT POSSIBLE IDs length " + gamesNotPossible.length)

    val sumOfIds = filteredGamesPossible.map(_.id).sum
    sumOfIds
  }

}

package Day2

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}

object Day2 {

  val input: String = Files.readString(Path.of("src/main/scala/Day2/Day2Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList


  case class Game(id: Int, cubeSets: List[CubeSet])

  case class CubeSet(blue: Int, red: Int, green: Int)

  def makeGame(string: String): Game = {
    val split1 = string.split(": ")
    val gameId = split1.head.substring(4).toInt

    val sets = split1.last.split(";")
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

}

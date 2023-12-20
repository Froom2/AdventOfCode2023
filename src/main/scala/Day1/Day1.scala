package Day1

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}
import scala.io.Source

object Day1 {

  val input: String = Files.readString(Path.of("src/main/scala/Day1/Day1Input.txt"), StandardCharsets.UTF_8)
  val trimmedList: List[String] = input.split("\\n").map(_.trim).toList



}

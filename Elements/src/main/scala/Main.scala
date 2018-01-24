object Main {

  def main(args: Array[String]): Unit = {

    val name = scala.io.StdIn.readLine("What is your name? ")
    println()

    Game.playGame(new Human(name), new AI()) match {
      case Some(p) => println(s"${p.name} won")
      case _ => println("It's a draw")
    }
  }
}

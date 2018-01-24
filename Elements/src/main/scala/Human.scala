import scala.io.StdIn.readLine

class Human(override val name: String) extends Player {

  override def play: Elements.Element = {
    var input = ""
    do {
      input = getInput
    } while (!validate(input))
    println()
    if (input equalsIgnoreCase "quit") {
      hand.clear()
      Elements.Neutral(-1)
    }
    else
      hand(input.toInt)
  }

  def getInput: String = {
    for (i <- hand.indices)
      println(s" $i > ${hand(i)}")
    readLine("Enter the element of choice: ")
  }

  def validate(input: String): Boolean = {
    if (input equalsIgnoreCase "help") {
      printHelp()
      false
    }
    else if (input equalsIgnoreCase "quit") {
      areYouSure
    }
    else if (input.exists(ch => !ch.isDigit)) {
      println("Not a number!")
      false
    }
    else if (input.toInt < 0 || (input.toInt >= hand.size)) {
      println("Number out of range")
      false
    }
    else
      true
  }

  def areYouSure: Boolean = {
    readLine("Are you sure? ").toLowerCase().startsWith("y")
  }

  def printHelp(): Unit = {
    println("\n -- Help menu --")
    println("The aim of the game is to get the opponent to use up all their elements")
    println("You do so by winning a sort of enhanced version of rock, paper, scissors\n")
    println("Winner is decided by Elemental strength")
    println(" Fire > Earth")
    println(" Earth > Air")
    println(" Air > Water")
    println(" Water > Fire\n")
    println("If the types don't match in that way, power (the number) is taken into account")
    println("Highest wins. Both lose in case of a draw\n")
  }
}

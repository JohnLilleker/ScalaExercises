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
    for (i <- hand.indices) {
      print(s" $i > ${hand(i)}")
      if (boost(hand(i)) > 0) print("*")
      println
    }
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
    println("You do so by winning mini duels with element 'cards'\n")
    println("The card with the highest power wins. The face value can be augmented through 2 methods")
    println("Elemental strength doubles the face value")
    println(" Fire > Earth")
    println(" Earth > Air")
    println(" Air > Water")
    println(" Water > Fire\n")
    println("The other way is through your element, if you have one (the element in brackets next to your name).")
    println("If it matches the element you cast, it gets a +3 strength boost (after strength is considered).")
    println("This is also marked by the * next to the 'card'")
    println("Highest wins. Both lose in case of a draw\n")
  }
}

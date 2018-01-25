
object Game {
  def playGame(p1: Player, p2: Player): Option[Player] = {
    val deck = new ElementDeck
    deck.create()

    val cards = deck.deal()

    p1.takeHand(cards._1)
    p2.takeHand(cards._2)

    println("Elements!")
    println()

    while(!p1.noElements && !p2.noElements) {
      println(p1.info)
      println(p2.info)

      val element1 = p1.play
      val element2 = p2.play
      val stab1 = p1.boost(element1)
      val stab2 = p2.boost(element2)

      println(s"$element1${if (stab1>0) "*" else ""} vs $element2${if (stab2>0) "*" else ""}")
      val result = Elements.compareElements(element1, element2, stab1, stab2)

      if (result.nonEmpty) {
        if (result.get == element1) {
          println(s"${p1.name} wins")
          p2.discardElement(element2)
        }
        else {
          println(s"${p2.name} wins")
          p1.discardElement(element1)
        }
      }
      else {
        println("Draw")
        p1.discardElement(element1)
        p2.discardElement(element2)
      }
      println()
    }
    println("Game over")
    if (!p1.noElements) Some(p1)
    else if (!p2.noElements) Some(p2)
    else None
  }
}

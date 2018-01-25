import Elements._

class ElementDeck {

  private var elements = scala.collection.mutable.ArrayBuffer.empty[Element]

  def create(): Unit = {
    for (i <- 1 to 10)
       elements = elements :+ Fire(i) :+ Water(i) :+ Earth(i) :+ Air(i)
    for (i <- 1 to 10)
      elements = elements :+ Neutral(i)
  }

  def deal(hand: Int = 7): (List[Element], List[Element]) = {

    var (hand1, hand2) = (List[Element](), List[Element]())
    elements = scala.util.Random.shuffle(elements)
    var i = 0
    while (i < elements.size && i < hand * 2) {
      hand1 = hand1 :+ elements(i)
      hand2 = hand2 :+ elements(i + 1)
      i += 2
    }
    (hand1, hand2)
  }
}

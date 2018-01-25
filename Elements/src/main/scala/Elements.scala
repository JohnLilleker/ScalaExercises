
// case classes describing the 4 elements( + neutral) and a method for comparing them
object Elements {

  sealed abstract class Element {
    protected val power: Int
    def strength: Int = power
  }

  case class Fire(override val power: Int) extends Element

  case class Water(override val power: Int) extends Element

  case class Earth(override val power: Int) extends Element

  case class Air(override val power: Int) extends Element

  case class Neutral(override val power: Int) extends Element

  /**
    * Compares 2 elements and returns which is stronger. The strength is given by face value
    *
    * @param e1 the first element
    * @param e2 the second element
    * @param boost1 an amount the player casting the first element can boost the power
    * @param boost2 an amount the player casting the second element can boost the power
    * @return An optional of who won, or None if a draw
    */
  def compareElements(e1: Element, e2: Element, boost1: Int, boost2: Int): Option[Element] = {

    def comp_strength(e1: Element, boost1: Int, e2: Element, boost2: Int): Option[Element] = {
      val pow1 = e1.strength + boost1
      val pow2 = e2.strength + boost2
      if (pow1 > pow2) Some(e1)
      else if (pow2 > pow1) Some(e2)
      else None
    }

    var strength1 = 0
    var strength2 = 0
    (e1, e2) match {
      case (Fire(x), Earth(_)) => strength1 = x
      case (Fire(_), Water(x)) => strength2 = x

      case (Water(x), Fire(_)) => strength1 = x
      case (Water(_), Air(x)) => strength2 = x

      case (Earth(x), Air(_)) => strength1 = x
      case (Earth(_), Fire(x)) => strength2 = x

      case (Air(x), Water(_)) => strength1 = x
      case (Air(_), Earth(x)) => strength2 = x

      case _ =>
    }
    comp_strength(e1, boost1 + strength1, e2, boost2 + strength2)
  }
}
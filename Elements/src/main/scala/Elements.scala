
// case classes describing the 4 elements and a method for comparing them
object Elements {

  sealed abstract class Element {
    val power: Int
    def strength: Int = power
  }

  case class Fire(override val power: Int) extends Element

  case class Water(override val power: Int) extends Element

  case class Earth(override val power: Int) extends Element

  case class Air(override val power: Int) extends Element

  case class Neutral(override val power: Int) extends Element

  /**
    * Compares 2 elements and returns which is stronger. In the case of elements being balanced, strength is taken into consideration
    *
    * @param e1 the first element
    * @param e2 the second element
    * @return An optional of who won, or None if a draw
    */
  def compareElements(e1: Element, e2: Element): Option[Element] = {

    def comp_strength(e1: Element, e2: Element): Option[Element] = {
      if (e1.strength > e2.strength) Some(e1)
      else if (e2.strength > e1.strength) Some(e2)
      else None
    }

    e1 match {
      case Fire(_) =>
        e2 match {
          case Water(_) => Some(e2)
          case Earth(_) => Some(e1)
          case Air(_) | Fire(_) | Neutral(_) => comp_strength(e1, e2)
          case _ => None
        }
      case Water(_) =>
        e2 match {
          case Air(_) => Some(e2)
          case Fire(_) => Some(e1)
          case Water(_) | Earth(_) | Neutral(_) => comp_strength(e1, e2)
          case _ => None
        }
      case Earth(_) =>
        e2 match {
          case Fire(_) => Some(e2)
          case Air(_) => Some(e1)
          case Water(_) | Earth(_) | Neutral(_) => comp_strength(e1, e2)
          case _ => None
        }
      case Air(_) =>
        e2 match {
          case Earth(_) => Some(e2)
          case Water(_) => Some(e1)
          case Air(_) | Fire(_) | Neutral(_) => comp_strength(e1, e2)
          case _ => None
        }
      case Neutral(_) => comp_strength(e1, e2)
      case _ => None
    }
  }
}
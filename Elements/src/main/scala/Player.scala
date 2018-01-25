import scala.collection.mutable.ListBuffer
import Elements._
abstract class Player(protected var hand: ListBuffer[Elements.Element] = ListBuffer()) {
  val name: String
  val element: Element = pickElement

  def showHand(): Unit = println(hand)

  def play: Element

  def discardElement(ele: Element): Unit = hand -= ele

  def noElements: Boolean = hand.isEmpty

  def clear(): Unit = hand.clear()

  def takeHand(list: List[Element]): Unit = list.foreach(ele => hand += ele)

  def stock: Int = hand.size

  def info: String = {
    val ele = if (element != Neutral(0)) s"[$element] " else ""
    s"$ele$name | ${"*" * stock}"
  }

  def pickElement: Element = {
    // players can have elements too!
    // shared elements (except neutral) get a +3 boost to power
    // 1/2 chance of getting a boost, 1/4 chance of that for each element
    val boost = 3
    val boosters = Array(Fire(boost), Neutral(0), Water(boost), Neutral(0), Air(boost), Neutral(0), Earth(boost), Neutral(0))
    boosters(scala.util.Random.nextInt(boosters.length))
  }

  def boost(ele: Element): Int = (ele, element) match {
    case (Fire(_), Fire(x)) => x
    case (Water(_), Water(x)) => x
    case (Earth(_), Earth(x)) => x
    case (Air(_), Air(x)) => x
    case _ => 0
  }

  override def toString: String = {
    val ele = if (element != Neutral(0)) s"[$element] " else ""
    val str = new StringBuilder(s"$ele$name: ")
    hand.foreach(ele => str.append(ele).append(","))
    str.toString()
  }
}

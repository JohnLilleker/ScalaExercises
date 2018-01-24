import scala.collection.mutable.ListBuffer

abstract class Player(protected var hand: ListBuffer[Elements.Element] = ListBuffer()) {
  val name: String

  def showHand(): Unit = println(hand)

  def play: Elements.Element

  def discardElement(ele: Elements.Element): Unit = hand -= ele

  def noElements: Boolean = hand.isEmpty

  def clear(): Unit = hand.clear()

  def takeHand(list: List[Elements.Element]): Unit = list.foreach(ele => hand += ele)

  def stock: Int = hand.size

  def info: String = s"$name | ${"*" * stock}"

  override def toString: String = {
    val str = new StringBuilder(s"$name : ")
    hand.foreach(ele => str.append(ele).append(","))
    str.toString()
  }
}


class AI(override val name: String = "Element Caster") extends Player {

  override def play: Elements.Element = hand(scala.util.Random.nextInt(hand.size))

}

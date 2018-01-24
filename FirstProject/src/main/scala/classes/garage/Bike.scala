package classes.garage

class Bike(override val colour: String, override val owner: Customer, override val id: Int) extends Vehicle {
  override def toString: String = s"I am a $colour bike and my owner is $owner"
}

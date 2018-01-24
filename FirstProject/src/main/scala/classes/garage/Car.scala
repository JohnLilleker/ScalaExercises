package classes.garage

class Car(override val colour: String, override val owner: Customer, override val id: Int) extends Vehicle {
  override def toString: String = s"I am a $colour car that belongs to $owner"
}
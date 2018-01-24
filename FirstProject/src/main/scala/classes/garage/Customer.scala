package classes.garage

class Customer(override val name: String, override val age: Int, val customer_id: Int) extends Person(name, age) {
  override def toString: String = super.toString + s". I am a loyal customer, id $customer_id"
}

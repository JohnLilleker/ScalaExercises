package classes.garage

class Employee(override val name: String, override val age: Int, val employee_id: Int) extends Person(name, age) {
  override def toString: String = super.toString + s". My employee id is $employee_id"
}

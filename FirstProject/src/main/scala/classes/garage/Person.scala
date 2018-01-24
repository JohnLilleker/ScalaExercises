package classes.garage

class Person(val name: String, val age: Int) {
  override def toString: String = s"My name is $name and I am $age years old"
}
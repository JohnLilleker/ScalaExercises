package classes.garage


object Main {
  def main(args: Array[String]): Unit = {
    val e = new Employee("17", 3, 0)
    val c = new Customer("17", 3, 0)

    println(e)
    println(c)
  }
}

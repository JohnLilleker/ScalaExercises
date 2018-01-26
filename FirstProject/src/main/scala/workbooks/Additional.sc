
def doStuff(name: String, address: String): Unit = {
  println(s"My name is ${name.toUpperCase()} and I am at ${address.toLowerCase()}")
}
doStuff("Some Person", "Rustboro, the Hoenn Region")

def threeDP(x: Double): Unit = {
  println(f"$x%.3f")
}
threeDP(3.14159)

def rev(str: String): Unit = {
  println(str.reverse)
}
rev("racecar")
rev("level")
rev("aibohphobia")
rev("Pallendromes!")
rev("Manchester")

def ageInSeconds(age: Int): Unit = {
  val secs = (age * 365.35 * 24 * 60 * 60).toInt
  println(f"You would have been $secs%,d seconds old on your $age birthday, midnight")
}
ageInSeconds(22)


List(1, 4, 8, 20, 40, 28, 16).map(n => if (n > 20) n*10 else n)
List("me", "you", "potato", "beans", "egg").filter(str => str.length > 4)

val fruit = List("Apple", "Raspberry", "Lemon", "Kiwi", "Strawberry")

// the solution it wants
var long = ""
fruit.foreach(f => if (f.length > long.length) long = f)
long

// my solution
fruit.maxBy(f => f.length)
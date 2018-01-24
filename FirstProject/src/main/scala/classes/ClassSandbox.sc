
abstract class Soldier {
  def health : Int
  def attack
  def move
  def cost : Int
  def damage
}

class Grunt extends Soldier {
  override def attack: Unit = println("DIE!!!")
  override def damage: Unit = println("Ow")
  override def cost: Int = 2
  override def move: Unit = println("Moving swiftly")
  override def health: Int = 10

  override def toString: String = "Cannon fodder"
}

class Goliath extends Soldier {
  override def attack: Unit = println("GRAAAHHHH!!!!")
  override def damage: Unit = println("Your puny weapons are no match for me")
  override def cost: Int = 700
  override def health: Int = 100
  override def move: Unit = println("I do not need to move")

  override def toString: String = "A big guy"
}

class FarShot extends Soldier {
  override def attack: Unit = println("I cannot miss")
  override def cost: Int = 5
  override def damage: Unit = println("You missed")
  override def health: Int = 15
  override def move: Unit = println("As silent as a shadow...")

  override def toString: String = "A long range attacker"
}

val army = List(new Grunt, new Goliath, new FarShot)

army.foreach(u => {
  println(u)
  u.attack
  u.move
  u.damage
})




def cardIsValid(card : String) : Boolean = {
  if (card.forall(ch => ch.isDigit)) {
    val str = new StringBuilder
    val card_rev = card.reverse
    for (i <- 0 until card.length) {
      val ch = card_rev(i).asDigit
      str.append(if (i % 2 == 0) ch else ch * 2)
    }
    str.toList.map(ch => ch.asDigit).sum % 10 == 0
  }
  else
    false
}

cardIsValid("49927398716")
cardIsValid("49927389716")
cardIsValid("79927398713")
cardIsValid("79922398713")

// a solution without the StringBuilder
def cardIsValid2(card : String) : Boolean = {
  if (card.forall(ch => ch.isDigit)) {
    var sum = 0
    val card_rev = card.reverse
    for (i <- 0 until card.length) {
      var ch = card_rev(i).asDigit
      if (i % 2 == 1) {
        ch *= 2
        if (ch >= 10) ch -= 9
      }
      sum += ch
    }
    sum % 10 == 0
  }
  else
    false
}


cardIsValid2("49927398716")
cardIsValid2("49927389716")
cardIsValid2("79927398713")
cardIsValid2("79922398713")

val add7 = (x : Int) => {
  println("7")
  x + 7
}
val add4 = (x : Int) => {
  println("4")
  x + 4
}
val mul3 = (x : Int) => {
  println("3")
  x * 3
}
val mul5 = (x : Int) => {
  println("5")
  x * 5
}

def add(x : Int) = x+7

add7(5)
add4(5)
mul3(5)
mul5(5)

(mul3 compose add4 andThen mul5 compose add7)(4)
(mul3 andThen add4 compose mul5 andThen add7)(4)


sealed abstract class Element(power : Int) {
  val strength = power
}
case class Fire  (power : Int) extends Element(power)
case class Water (power : Int) extends Element(power)
case class Earth (power : Int) extends Element(power)
case class Air   (power : Int) extends Element(power)

class Magic (power : Int) extends Element(power)

val ele:Element = Air(20)

val e = new Magic(70)
val e2 = Water(49)

ele match {
  case Fire  (pow) => println(s"Fire discovered, intensity : $pow")
  case Water (pow) => println(s"Water discovered, strength : $pow")
  case Earth (pow) => println(s"Earth discovered, hardness : $pow")
  case Air   (pow) => println(s"Air discovered, speed : $pow")
  case _ => println("Unknown element")
}

def compareElements(e1 : Element, e2 : Element) : Option[Element] = {

  def comp_strength(e1 : Element, e2 : Element) : Option[Element] = {
    if (e1.strength > e2.strength) Some(e1)
    else if (e1.strength < e2.strength) Some(e2)
    else None
  }

  e1 match {
    case Fire (_) =>
      e2 match {
        case Water(_) => Some(e2)
        case Earth(_) => Some(e1)
        case Air(_) | Fire(_) => comp_strength(e1, e2)
        case _ => None
    }
    case Water (_) =>
      e2 match {
        case Air(_) => Some(e2)
        case Fire(_) => Some(e1)
        case Water(_) | Earth(_) => comp_strength(e1, e2)
        case _ => None
    }
    case Earth (_) =>
      e2 match {
        case Fire(_) => Some(e2)
        case Air(_) => Some(e1)
        case Water(_) | Earth(_) => comp_strength(e1, e2)
        case _ => None
    }
    case Air (_) =>
      e2 match {
        case Earth(_) => Some(e2)
        case Water(_) => Some(e1)
        case Air(_) | Fire(_) => comp_strength(e1, e2)
        case _ => None
      }
    case _ => None
  }
}

compareElements(Earth(30), Earth(35))
compareElements(Water(30), Earth(35))
compareElements(Fire(30), Earth(35))
compareElements(Air(30), Earth(35))
compareElements(Earth(30), Air(35))
compareElements(Water(30), Air(35))
compareElements(Fire(30), Air(35))
compareElements(Air(30), Air(35))
compareElements(Earth(30), Water(35))
compareElements(Water(30), Water(35))
compareElements(Fire(30), Water(35))
compareElements(Air(30), Water(35))
compareElements(Earth(30), Fire(35))
compareElements(Water(30), Fire(35))
compareElements(Fire(30), Fire(35))
compareElements(Air(30), Fire(35))

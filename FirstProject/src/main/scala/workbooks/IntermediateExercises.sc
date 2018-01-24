
// Blackjack
def blackjack(score1 : Int, score2 : Int) : Int = {
  val diff1 = 21 - score1
  val diff2 = 21 - score2

  if (diff1 < 0 && diff2 < 0) 0
  else if (diff2 < 0) score1
  else if (diff1 < 0) score2
  else if (diff1 < diff2) score1 else score2
}

blackjack(18, 21)
blackjack(20, 18)
blackjack(22, 22)
blackjack(18, 23)
blackjack(20, 20)

// unique sum
def uniqueSum(a : Int, b : Int, c : Int) : Int = {
  var res = 0
  if (a != b && a != c) res += a
  if (b != a && b != c) res += b
  if (c != a && c != b) res += c
  res
}
uniqueSum(1,2,3)
uniqueSum(3,3,3)
uniqueSum(1,1,2)

// too hot
def tooHot(temp : Int, isSummer : Boolean) : Boolean = {
  if (temp < 60)
    false
  else
    temp <= (if (isSummer) 100 else 90)
}
tooHot(80, isSummer = false)
tooHot(100, isSummer = false)
tooHot(100, isSummer = true)
tooHot(110, isSummer = true)

// Playing with Scala

var undo = scala.collection.mutable.ArrayStack[Int](1, 4, 5)

for (i <- 0 until 10 by 3) undo.push(i)
undo

while (undo.nonEmpty)
  print(s"${undo.pop()} ")
undo

val vec = for (i <- 0 to 10) yield i
vec.take(3)

vec(4)

val dict = Map(1 -> "a", 2 -> "b", 3 -> "c")
dict(2)
dict.get(2)
dict.get(7)
dict.getOrElse(3, "No element")
dict.getOrElse(6, "No element")

val x = "hello world"
x.map(c => c - 2).map(c => c.toChar) mkString ""

val li = List(2,6,3,9,0,3,7,12)
val (even, odd) = li.partition(x => x % 2 == 0)
even
odd

li.takeWhile(x => x < 7)

val dominoes = (for (i <- 1 to 6; j <- i to 6) yield (i, j)).toList
dominoes.foreach(println)

val ter = if (li.size < 7) "hi" else "hello"
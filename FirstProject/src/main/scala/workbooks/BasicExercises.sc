// Hello 'World'
println("Hello Scala")

// Strings 1
def reverseSub(str : String, x : Int) : String = {
  val end = str.size - x;
  str.substring(end)
}
reverseSub("hello", 3)

// Strings 2
def stringSplice(str1 : String, str2 : String, find : Char, replace : Char) : String = {
  val resultStr = str1.concat(str2)
  resultStr.replace(find, replace)
}
stringSplice("ha", "llo", 'a', 'e')

// Operators, Conditionals 1 and Conditionals 2
def sum (x : Int, y : Int, calcSum : Boolean = true) : Int = {

  if (x == 0) y
  else if (y == 0) x
  else if (calcSum) x + y
  else x * y
}

s"3 + 5 = ${sum(3, 5)}"
s"3 * 5 = ${sum(3, 5, false)}"
sum(0, 4)
sum(5, 0)
sum(0, 0)

// iteration 1
def loopPrint(str : String, x : Int) : Unit = {
  for (i <- 1 to x) {
    println(str)
  }
}
loopPrint("Hi", 3)

// iteration 2
def squarePrint(str : String, x : Int) : Unit = {
  for (_ <- 1 to x) {
    for (_ <- 1 to x) {
      print(str)
    }
    println()
  }
}
squarePrint("H", 4)

// iteration 3
def words(str1 : String, str2 : String, num : Int) : Unit = {
  for (i <- 1 to num ) {
    var word = false
    if (i % 3 == 0) {
      print(str1)
      word = true
    }
    if (i % 5 == 0) {
      print(str2)
      word = true
    }
    if (!word) print(i)
    print(",")
  }
}
words("Fizz", "Buzz", 15)

// recursion
def recursionPrint(str : String, x : Int) : Unit = {
  if (x > 0) {
    println(str)
    recursionPrint(str, x-1)
  }
}
recursionPrint("Hi", 4)

def recursionPrintWords(div3 : String, div5 : String, num : Int) : Unit = {
  if (num <= 0) { return  }
  else if (num % 15 == 0) { // % 5 and % 3
    recursionPrintWords(div3, div5, num - 1)
    print(s"$div3$div5,")
  }
  else if (num % 5 == 0) {
    recursionPrintWords(div3, div5, num - 1)
    print(s"$div5,")
  }
  else if (num % 3 == 0) {
    recursionPrintWords(div3, div5, num - 1)
    print(s"$div3,")
  }
  else {
    recursionPrintWords(div3, div5, num - 1)
    print(s"$num,")
  }
}
recursionPrintWords("Fizz", "Buzz", 15)

// pattern matching
def patternSum(x : Int, y : Int, useSum : Boolean) : Int = (x, y, useSum) match {
  case (0, y1, _) => y1
  case (x1, 0, _) => x1
  case (x1, y1, true)  => x1+y1
  case (x2, y2, false) => x2*y2
}
patternSum(5, 7, true)
patternSum(5, 7, false)
patternSum(5, 0, false)

// trying to pattern match general collections...
def swap(pair : Any) : (Any, Any) = pair match {
  case (x, y) => (y, x)
  case (x :: (y :: _)) => (y, x)
  case Array(x, y, _*) => (y, x)
  case _ => null
}

swap((4, 9))
swap(Tuple2(5, 9))
swap(List(1,2,3,4,5))
swap(Array(2,3,4))
swap((2,4,6,7))

// Playing with Scala
def listIsEvenSize(li : List[Any]) : Boolean = li match {
  case _ :: (_ :: c) => listIsEvenSize(c)
  case Nil => true
  case _ => false
}

listIsEvenSize(List())
listIsEvenSize(List(2, 5, 7, 8, 6))
listIsEvenSize(List(2, 5))
listIsEvenSize(List(2))
listIsEvenSize(List(2, 5, 7, 8, 6, 6))

List(1,2,3,4,5,6).slice(3, 5)

var z = (for (i <- 1 to 100
              if i % 5 != 0
              if i % 3 != 0
    if i % 2 != 0) yield i).toList

for (i <- z if i % 7 == 0){
  println(i)
}


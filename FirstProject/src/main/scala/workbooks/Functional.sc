
def isFibonacci(nums: List[Int]): Boolean = {
  val sorted = nums.sorted.reverse

  def isFibonacciR(li: List[Int]): Boolean = li match {
    case Nil => true
    case 0 :: Nil => true
    case 1 :: (0 :: Nil) => true
    case z :: (y :: (x :: tail)) if x + y == z => isFibonacciR(y :: x :: tail)
    case _ => false
  }
  isFibonacciR(sorted)
}

// fibonacci infinite stream
lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)

isFibonacci(List(1, 0, 1, 2))
isFibonacci(List(1, 0, 1, 5))
isFibonacci(fibs.take(25).toList)
isFibonacci(List(0,1,1,2,3,5,8,13,21,34,55,89,144,233,377))

def gcd(a: Int, b: Int): Int = (a, b) match {
  case (x, 0) => x
  case (x, y) => gcd(y, x % y)
}

gcd(1071, 462)
gcd(7, 21)
gcd(9, 14)

def fact(num: Int) = {
  def factR(x: Int, i: Int): Int = (x, i) match {
    case (y, result) if y <= 1 => result
    case (y, j) => factR(y-1, j*y)
  }
  factR(num, 1)
}

fact(5)

val isIn = (str1: String, str2: String) => str2.toLowerCase().contains(str1.toLowerCase())

isIn("hi", "thing")
isIn("World", "Hello world")
isIn("abc", "alphabet")

def stringComparing(test: (String,String) => Boolean, str1: String, str2: String): Boolean = {
  test(str1, str2)
}

stringComparing(isIn, "yea", "yeah")

stringComparing((s1: String, s2: String) => s2.contains(s1), "hi", "thing")

def thing1(value: Double): Double = {
  var discounted = value
  if (value > 50) discounted *= 0.9
  discounted * 1.2
}

thing1(30)
thing1(60)

def thing2(quantity: Int)(price: Double)(discountable: Double => Double): Double = {
  discountable(quantity*price) * 1.2
}

val applyQuant = thing2(3)(_)
val applyPrice = applyQuant(19.99)(_)
val applyQuantAndPrice = thing2(3)(19.99)(_)

val disc = (cost: Double) => if (cost > 40) cost * 0.9 else cost

applyPrice(disc)
applyQuantAndPrice(disc)
thing2(3)(19.99)(disc)
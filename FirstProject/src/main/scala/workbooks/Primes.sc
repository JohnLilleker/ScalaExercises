
def findPrimes(x : Int) = {
  var sieve = (0 until x).map(_ => false).toArray



  (for (i <- 0 until x if sieve(i)) yield i).toVector
}
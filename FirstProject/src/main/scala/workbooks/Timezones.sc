
java.util.TimeZone.getAvailableIDs
  .map(_ split "/")
  .filter(_.length > 1)
  .map(_(1))
  .grouped(10)
  .map(_(0))
  .toArray

(for (j <- List("d","h","c","s"); i <- 1 to 13) yield (i, j))
  .map({
    case (1, s) => ("A", s)
    case (11, s) => ("J", s)
    case (12, s) => ("Q", s)
    case (13, s) => ("K", s)
    case (v, s) => (v.toString, s)
    case _ => null
  }).toVector


def function(a : Int*) = {
  a.reduce((x,y) => (x+y)/2)
}
function(1,4,8,3,9)

def anon(y : Int) : Int => Int = {
  x => x + y
}
anon(10)(20)

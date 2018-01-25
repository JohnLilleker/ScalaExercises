
def LCSStr(str1: String, str2: String) = {
  if (str1.contains(str2)) str2
  else if (str2.contains(str1)) str1
  else {
    var (index, size, lcs) = (0, 1, "")
    val current_sub = new StringBuilder

    while (index + size <= str1.length) {

      val sub = str1.substring(index, index+size)
      println("sub " + sub)
      if (str2.contains(sub)) {
        // wrong, need to
        current_sub.append(str1.charAt(index+size-1))
        size += 1
      }
      else {
        println("cSub " + current_sub.toString())
        println("lcs " + lcs)
        if (current_sub.size > lcs.length) {
          lcs = current_sub.toString()
          current_sub.clear()
        }
        index += 1
      }
    }
    if (current_sub.size > lcs.length) {
      lcs = current_sub.toString()
    }
    lcs
  }
}

LCSStr("banana", "Ekans")
LCSStr("abcd", "efgh")
LCSStr("Elephant", "Gigantic")
LCSStr("chimpanzees", "humans")

def LCSSeq(str1: String, str2: String) = {
  // subsequence

}

def strRec(str: Seq[Char]): Unit = str match {
  case a +: b => {
    println(a)
    strRec(b)
  }
  case Nil => println("End")
  case _ => println("Unknown")
}
strRec("abcde")
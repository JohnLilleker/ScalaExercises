
def LCSStr(str1: String, str2: String) = {
  def subs(str: String) = str.inits.flatMap(_.tails).toSet
  (subs(str1) & subs(str2)).maxBy(_.length)
}

LCSStr("chimpanzee", "human")
LCSStr("ftgjmbcgbnvvxtargetuhtfyjmgr", "fkhmudtargetljmghniuckmtxj")

def LCSSeq(str1: String, str2: String): String = {

  def maxStr(str1: String, str2: String): String = if (str1.length > str2.length) str1 else str2

  def LCSRec(str1: Seq[Char], str2: Seq[Char]): String = (str1, str2) match {
    case (Nil, _) | (_, Nil) => ""
    case (h1 +: t1, h2 +: t2) if h1 == h2 => h1 + LCSRec(t1, t2)
    case (h1 +: t1, h2 +: t2) => maxStr(LCSRec(t1, h2 +: t2), LCSRec(h1 +: t1, t2))
  }

  LCSRec(str1, str2)
}

LCSSeq("chimpanzee", "human")
LCSSeq("XMJYAUZ", "MZJAWXU")
LCSSeq("abc", "def")

fun SieveOfAtkin(limit:Int)
{
  var output = ""

  // 2 and 3 are known to be prime
  if (limit > 2) {output += "2 "}

  if (limit > 3) {output += "3 "}

  // Initialise the sieve array with false values

  val sieve = MutableList(limit){false}

  var x = 1
  while (x * x < limit) {
    var y = 1
    while (y * y < limit) {

      // Main part of Sieve of Atkin
      var n = (4 * x * x) + (y * y)
      if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {sieve[n] = sieve[n].xor(true)}

      n = (3 * x * x) + (y * y)
      if (n <= limit && n % 12 == 7) {sieve[n] = sieve[n].xor(true)}

      n = (3 * x * x) - (y * y)
      if (x > y && n <= limit && n % 12 == 11) {sieve[n] = sieve[n].xor(true)}
      y += 1
    }
    x +=1
  }

  // Mark all multiples of squares as
  // non-prime
  var r = 5
  while (r * r < limit) {
    if (sieve.get(r)) {
      var i = r * r
      while (i < limit)
      {
        sieve.set(i, false)
        i += r * r
      }
    }
    r += 1
  }

  print ("[OUTPUT] " + output)
  // Print primes using sieve[]
  var a = 5
  while (a < limit) {
    if (sieve.get(a)) { print("$a ") }
    a += 1
  }

  println()
}

fun main() {
  val N: Int = 10
  println("[INPUT] " + N)
	SieveOfAtkin(N)
}

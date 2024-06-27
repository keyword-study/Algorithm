package seungheyon.programmers

import kotlin.math.sqrt

public class PrimeNumber1 {

    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val numbers = convertK(n, k).split("0")
        for (number: String in numbers) {
            if (number == "") {
                continue
            }
//            val intPrime = if(k>10){
//                number.toInt(k)
//            } else {
            val intPrime = number.toLong()
//            }
            if (isPrime(intPrime)) {
                answer++
            }
        }

        return answer
    }

    private fun convertK(n: Int, k: Int): String {

        if (n == 0) {
            return "0"
        }
        var num = n
        var cn = 0L
        var x = 1L

        while (num != 0) {
            val remain = num % k
            cn += x * remain
            x *= 10
            num /= k
        }

        return cn.toString()
    }

    private fun isPrime(n: Long): Boolean {
        if (n == 1L) {
            return false
        }
        if (n == 2L) {
            return true
        }
        var i = 2
        while (i <= sqrt(n.toDouble()) + 1) {
            if (n % i++ == 0L) return false
        }
        return true
    }
}
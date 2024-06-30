package seungheyon.programmers.primeNumber

class PN {
    fun main(args: Array<String>) {
        val n = 437674
        val k = 3
        val result = solution(n,k)
        println(result) // Example usage
    }

    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val numbers = convertK(n, k).split("0")
        numbers.forEach {
            val intPrime = if(k>10){
                it.toInt(k)
            } else {
                it.toInt()
            }
            if(isPrime(intPrime)){
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
        val sb = StringBuilder()

        while (num != 0) {
            val remain = num % k
            if (remain > 9) {
                sb.insert(0, (remain + 55).toChar())
            } else {
                sb.insert(0, remain)
            }
            num /= k
        }

        return sb.toString()
    }

    private fun isPrime(n: Int): Boolean {
        if(n==1){
            return false
        }
        var i = 2
        while (i * i <= n) {
            if (n % i++ == 0) return false
        }
        return true
    }
}
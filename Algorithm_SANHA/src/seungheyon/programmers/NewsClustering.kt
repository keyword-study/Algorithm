package seungheyon.programmers

class NewsClustering {
    fun solution(str1: String, str2: String): Int {
        str1.uppercase()
        str2.uppercase()

        var str1Set = ArrayList<String>()
        var str2Set = ArrayList<String>()
        for(i in 0 ..str1.length-2){
            val str = str1.substring(i,i+2)
            if(str.matches(Regex("[a-zA-Z]+"))){
                str1Set.add(str)
            }
        }
        for(i in 0 ..str2.length-2){
            val str = str2.substring(i, i+2)
            if(str.matches(Regex("[a-zA-Z]+"))){
                str2Set.add(str)
            }
        }
        str2Set.addAll(str1Set)
        val sum = str2Set.size
        str1Set.retainAll(str2Set)
        val sub = str1Set.size

        val ja : Double = (sub/sum).toDouble()
        val intJa = (ja * 65536).toInt()

        return intJa
    }
}
package leetcode.arrays101

class AddBinary {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }

    fun addBinaryString(a: String, b: String): String {
        var a = a
        var b = b
        if (b.length >= a.length) a = b.also { b = a }
        for (i in 1..a.length - b.length) {
            b = "0$b"
        }
        val size = a.length
        val temp = List(size) { 0 } .toMutableList()
        for (i in 0 .. a.lastIndex) {
            temp[i] = a[i].toString().toInt() + b[i].toString().toInt()
        }

        if (temp.contains(2)) temp.add(0, 0)

        for (i in temp.lastIndex downTo 0) {
            if (temp[i] >= 2) {
                temp[i] %= 2
                if (i -1 >= 0) temp[i - 1]++

            }
        }

        return temp.dropWhile { it == 0 && temp.size > 1 }.joinToString("")
    }
}

package leetcode.arrays101

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false
        val biggestValue = arr.max()
        if (arr.count { it == biggestValue } > 1)
            return false


        val biggestValueIndex = arr.indexOf(biggestValue)
        if(biggestValueIndex == arr.lastIndex || biggestValueIndex == 0)
            return false

        for (i in biggestValueIndex downTo 1) {
            if (arr[i] <= arr[i - 1])
                return false
        }

        for (i in biggestValueIndex until arr.lastIndex) {
            if (arr[i] <= arr[i + 1])
                return false
        }

        return true
    }
//
    fun validMountainArrayNeatSolution(arr: IntArray): Boolean {
        if (arr.size < 3) return false

        var pointer = 1;
        while (pointer < arr.size && arr[pointer] > arr[pointer - 1]) {
            pointer++
        }

        if (pointer == arr.size || pointer == 1) return false

        while (pointer < arr.size && arr[pointer] < arr[pointer - 1]) {
            pointer++
        }

        return arr.size == pointer
    }

}


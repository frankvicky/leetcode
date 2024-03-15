package leetcode.beginnerguide

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomNoteList = ransomNote.toMutableList()
        magazine.forEach {
            ransomNoteList.remove(it)
            if (ransomNoteList.isEmpty())
                return true
        }
        return false
    }

    fun canConstructWithMap(ransomNote: String, magazine: String): Boolean {
        val letterCount = hashMapOf<Char, Int>()
        magazine.forEach {
            if (letterCount[it] == null) {
                letterCount[it] = 0
            } else {
                letterCount[it] = letterCount[it]!! + 1
            }
        }
        ransomNote.toCharArray().forEach {
            if (letterCount[it] == null || letterCount[it] == 0) {
                return false
            }
            if (letterCount[it] != null) {
                letterCount[it] = letterCount[it]!! - 1
            }
        }

        return true
    }
}

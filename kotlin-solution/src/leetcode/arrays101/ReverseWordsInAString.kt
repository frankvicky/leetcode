package leetcode.arrays101

class ReverseWordsInAString {
    fun reverseWords(s: String): String = s.split(" ").reversed().filter { it.isNotEmpty() }.joinToString(" ")

    fun reverseWordsButKeepOriginalBlank(s: String): String {
        val reverseNotBlankString = s.split(" ").reversed().joinToString("")
        var notBlankPointer = 0
        val resultBuilder = StringBuilder("")
        s.reversed().forEach {
            if (it == ' ')
                resultBuilder.append(' ')
            else
                resultBuilder.append(reverseNotBlankString[notBlankPointer++])
        }
        return resultBuilder.toString()
    }
}

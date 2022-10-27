class RichestCustomerWealth {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        val intArray = accounts.map { array ->
            array.reduce { acc, next -> acc + next }
        }
        return intArray.max();
    }
}
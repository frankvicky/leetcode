package ting.leetcode.arrays101

class CorporateFlightBookings {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val bookedSeat = IntArray(n)
        for (booking in bookings) {
            increase(booking, bookedSeat)
        }

        for (i in 1..bookedSeat.lastIndex) {
            bookedSeat[i] += bookedSeat[i - 1]
        }
        return bookedSeat
    }

    private fun increase(booking: IntArray, array: IntArray) {
        val from = booking.first() - 1
        val to = booking[1] - 1
        val count = booking.last()
        array[from] += count
        if (to < array.lastIndex)
            array[to] -= count
    }
}

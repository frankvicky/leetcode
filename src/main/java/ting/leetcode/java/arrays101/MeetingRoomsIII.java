package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(arr -> arr[0]));
//        PriorityQueue<Room> freeRooms = new PriorityQueue<>(
//                Comparator.comparingInt((Room room) -> room.useCount)
//                        .thenComparingInt(room -> room.num)
//        );
        PriorityQueue<Room> freeRooms = new PriorityQueue<>(Comparator.comparingInt(r -> r.num));
        PriorityQueue<Room> inMeetings = new PriorityQueue<>(Comparator.comparingInt(m -> m.remainingHour));


        for (int i = 0; i < n; i++) {
            freeRooms.offer(new Room(i, 0, -1));
        }

        int i = 0;
        while (i < meetings.length) {
            int[] meeting = meetings[i];
            inMeetings.forEach(r -> --r.remainingHour);

            if (!freeRooms.isEmpty()) {
                assignRoom(meeting, freeRooms, inMeetings);
            } else {
                while (!inMeetings.isEmpty() && inMeetings.peek().remainingHour > 0) {
                    inMeetings.forEach(r -> --r.remainingHour);
                }

                while (!inMeetings.isEmpty() && inMeetings.peek().remainingHour == 0) {
                    freeRooms.offer(inMeetings.poll());
                }

                if (!freeRooms.isEmpty()) {
                    assignRoom(meeting, freeRooms, inMeetings);
                    continue;
                }
            }
            i++;
        }


//        freeRooms.addAll(inMeetings);
        PriorityQueue<Room> rooms = new PriorityQueue<>(
                Comparator.comparingInt((Room room) -> -room.useCount)
                        .thenComparingInt(room -> room.num)
        );
        rooms.addAll(freeRooms);
        rooms.addAll(inMeetings);

        return rooms.poll().num;
    }

    private static void assignRoom(int[] meeting, PriorityQueue<Room> freeRooms, PriorityQueue<Room> inMeetings) {
        Room freeRoom = freeRooms.poll();
        freeRoom.useCount++;
        freeRoom.remainingHour = meeting[1] - meeting[0];
        inMeetings.offer(freeRoom);
    }

    public static void main(String[] args) {
        int[][] meetings =  {{0,10}, {1,5}, {2,7}, {3,4}, {8,11}, {9,12}};
        new MeetingRoomsIII().mostBooked(2, meetings);
    }

    class Room {
        final int num;
        int useCount;
        int remainingHour;


        public Room(int num, int useCount, int remainingHour) {
            this.num = num;
            this.useCount = useCount;
            this.remainingHour = remainingHour;
        }
    }

}

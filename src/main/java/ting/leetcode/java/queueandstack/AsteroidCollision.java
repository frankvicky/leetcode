package ting.leetcode.java.queueandstack;

import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> rightAsteroids = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (rightAsteroids.isEmpty() || asteroid > 0) {
                rightAsteroids.push(asteroid);
                continue;
            }

            while (true) {
                if (rightAsteroids.isEmpty() || rightAsteroids.peek() < 0) {
                    rightAsteroids.push(asteroid);
                    break;
                }

                int collisionResult = rightAsteroids.peek() + asteroid;
                if (collisionResult < 0) {
                    // 左移行星較大，因此把右移行星 pop 掉，然後繼續左移
                    rightAsteroids.pop();
                } else if (collisionResult > 0) {
                    break;
                } else {
                    // 左移行星和右移行星打小相等，因此抵銷
                    rightAsteroids.pop();
                    break;
                }
            }
        }

        int[] answers = new int[rightAsteroids.size()];
        for (int i = answers.length - 1; i >= 0; i--) {
            answers[i] = rightAsteroids.pop();
        }
        return answers;
    }
}

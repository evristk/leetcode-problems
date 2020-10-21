package lc_500_1000;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem #735 [Medium]
 *  Title: Asteroid Collision
 *  Link: https://leetcode.com/problems/clone-graph/
 *
 *  Summary: Find out the state of the asteroids after all collisions.
 *
 * @author Evripidis
 */
public class AsteroidCollision_735
{
	public int[] asteroidCollision(int[] asteroids) {

		// Store in a stack the asteroids going right
		//as we iterate through the asteroid array.
		Deque<Integer> rightAsteroids = new ArrayDeque<>(asteroids.length/2);

		List<Integer> survived = new ArrayList<>(asteroids.length/2);

		int i = 0;

		while (i < asteroids.length) {
			if (asteroids[i] > 0) {
				// Asteroid is going right. Store in stack.

				// When an asteroid going left is encountered,
				// it will confront the first in stack.
				rightAsteroids.push(asteroids[i]);
				i++;
			}
			else {
				// Asteroid going left is encountered.
				if (rightAsteroids.isEmpty()) {
					// No asteroid going right has been seen.
					// Nothing will happen.
					survived.add(asteroids[i]);
					// Go to next asteroid.
					i++;
				}
				else {
					// We have seen some asteroids going right.
					// Let's see what will happen.

					int rightPower = rightAsteroids.peek();
					int leftPower = Math.abs(asteroids[i]);

					if (leftPower < rightPower) {
						// Asteroid going right wins.
						// Don't remove from stack
						i++;
					}
					else if (leftPower == rightPower) {
						// Same power. Both destroyed
						rightAsteroids.poll();
						i++;
					}
					else {
						// Asteroid going left win.
						// It will confront the next in stack
						rightAsteroids.poll();
					}
				}
			}
		}

		// Iterate in reverse order through surviving asteroids going right
		Iterator<Integer> it = rightAsteroids.descendingIterator();

		while (it.hasNext()) {
			survived.add(it.next());
		}

		// Array of asteroids that have survived.
		return survived.stream().mapToInt(Integer::intValue).toArray();
	}
}

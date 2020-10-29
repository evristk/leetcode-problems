package lc_500_1000;


/**
 * Problem #849 [Medium]
 *  Title: Maximum Distance to Closest Person
 *  Link: https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
 *  Summary: Given an array representing seats[i] = 1 as person sitting
 *  in the i-th seat, and seats[i] = 0 means no one sitting. Alex wants to seat.
 *  Return the maximum distance to the closest person.
 *
 * @author Evripidis
 */
public class MaximumDistanceToClosestPerson_849 {

	public int maxDistToClosest(int[] seats) {

		int[] lDist = new int[seats.length];
		int[] rDist = new int[seats.length];

		int lastIndex = seats.length - 1;

		if (seats[0] == 0) {
			lDist[0] = Integer.MAX_VALUE;
		}

		if (seats[lastIndex] == 0) {
			rDist[lastIndex] = Integer.MAX_VALUE;
		}

		// Check distance from seats on the left
		int i = 1;

		while (i < seats.length) {

			if (seats[i] == 1) {
				//Someone is sitting
				lDist[i] = 0;
			}
			else {
				//No one is sitting
				lDist[i] = lDist[i - 1] + 1;
			}

			i++;

		}


		// Check distance from seat on the right,
		// while keeping track of the maximum distance so far,
		i = seats.length - 2;

		int maxDist = Math.min(lDist[lastIndex], rDist[lastIndex]);

		while (i >= 0) {

			if (seats[i] == 1) {
				//Someone is sitting
				rDist[i] = 0;
			}
			else {
				//No one is sitting
				rDist[i] = rDist[i + 1] + 1;
			}


			int closestDist = Math.min(rDist[i], lDist[i]);

			maxDist = Math.max(maxDist, closestDist);

			i--;
		}

		return maxDist;
	}
}

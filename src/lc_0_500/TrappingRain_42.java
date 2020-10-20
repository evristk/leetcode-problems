/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc_0_500;

/**
 Problem #403 [Hard]
 *  Title: Trapping rain
 *  Link: https://leetcode.com/problems/trapping-rain-water/
 *
 *  Summary: Given n non-negative integers representing an elevation map
 *          where the width of each bar is 1, compute how much water it
 *          can trap after raining.
 *
 * @author Evripidis
 */
public class TrappingRain_42 {
    // The key idea is to understand how to compute
    // the amount of rain a bucket i can hold. It depends on
    // the max height on the left of i, and max height on the right.
    // Then, we find the min of those max, and subtract the height of i.
    // If result > 0, that is the amount of water it can hold. Otherwise, 0.

    public int trap(int[] height)
    {
        int len = height.length;

        // Arrays for storing for each bucket i, the max height
        // it has been found on the left and right, correspondingly.
        int[] left = new int[len];
        int[] right = new int[len];

        int maxLeft = -1;
        int maxRight = -1;

        int l = 0;
        int r = len - 1;

        // Iterate from both directions to find maximum heights
        while (l < len)
        {
            // iterating from left -> right
            maxLeft = Math.max(maxLeft, height[l]);
            left[l] = maxLeft;

            // iterating from right -> left
            maxRight = Math.max(maxRight, height[r]);
            right[r] = maxRight;

            l++;
            r--;
        }

        // Count the accumulated amount of rain.
        int totalRain = 0;
        for (int i = 0; i < len; i++)
        {
            totalRain += Math.max(
                    Math.min(left[i], right[i]) - height[i],
                    0);
        }

        return totalRain;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc_1000_1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Problem #1002 [Easy]
 *  Title: Find Common Characterse
 *  Link: https://leetcode.com/problems/find-common-characters/
 *  Summary: You are given the root node of a binary search tree (BST)
 *           and a value to insert into the tree.
 * @author Evripidιs
 */
public class FindCommonCharacters_1002
{
    public static void main(String[] args)
    {

        String[] A = {"bella","label","roller"};

        FindCommonCharacters_1002 solver = new FindCommonCharacters_1002();

        List<String> output = solver.solution(A);

        System.out.println("Output: " + output.toString());
    }


     public List<String> solution(String[] A)
     {
         if (A.length == 0)
         {
             return Collections.EMPTY_LIST;
         }

          List<String> output = new ArrayList<>();

          // Build map that keeps track of the common characters.
          Map<String, Integer> charMap = createCharMap(A[0]);

         for (int i = 1; i < A.length; i++)
         {
            // build character-occurence map for each string
            // and compare it with the initial map
            // curate initial map

             String str = A[i];

             Map<String, Integer> tempMap = createCharMap(str);

             Iterator<Map.Entry<String, Integer>> iter = charMap.entrySet().iterator();

             while(iter.hasNext())
             {
                 Map.Entry<String, Integer> entry = iter.next();

                 if (tempMap.containsKey(entry.getKey()))
                 {
                     int currCharCount = tempMap.get(entry.getKey());
                     int commonCharCount = entry.getValue();

                     charMap.replace(entry.getKey(), Math.min(currCharCount,
                             commonCharCount));
                 }
                 else
                 {
                     // This char does not occur in the string we are checking
                     // so it is no longer candidate common string.
                     iter.remove();
                 }
             }
         }

         List<String> outputList = new ArrayList<>();

         charMap.forEach((key, value) -> {
             for (int i = 0; i < value; i++) {
                 outputList.add(key);
             }
         });

         return outputList;
     }


    public Map<String, Integer> createCharMap(String str)
    {
        Map<String, Integer> charMap = new HashMap<>();

        for (int j = 0; j < str.length(); j++)
        {
            String c = String.valueOf(str.charAt(j));

            charMap.compute(c, (key, val) ->
            {
                if (val == null)
                {
                    return 1;
                }
                else
                {
                    return val + 1;
                }
            });
        }

        return charMap;
    }
}

package org.example.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

@UtilityClass
public class Solution {

    public static int solution(int[] numbers) {
        int maxSum = -1;

        if (isNull(numbers) || numbers.length == 0) {
            return maxSum;
        }

        try {
            Map<Integer, Integer> pairs = extractPairs(numbers);
            return getMaxSum(maxSum, pairs);
        } catch (Exception e) {
            var errorMessage = String.format("Error trying to calculate maxSum from input array: %s", Arrays.toString(numbers));
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    private static int getMaxSum(int maxSum, Map<Integer, Integer> pairs) {
        for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            int sum = entry.getKey() + entry.getValue();
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static Map<Integer, Integer> extractPairs(int[] numbers) {
        Map<Integer, Integer> pairs = new HashMap<>();
        Map<String, Integer> firstLastDigitMap = new HashMap<>();

        for (int number : numbers) {
            String key = getFirstAndLastDigit(number);
            if (firstLastDigitMap.containsKey(key)) {
                pairs.put(firstLastDigitMap.get(key), number);
            } else {
                firstLastDigitMap.put(key, number);
            }
        }
        return pairs;
    }

    private static String getFirstAndLastDigit(int number) {
        String numStr = String.valueOf(number);
        return numStr.charAt(0) + "" + numStr.charAt(numStr.length() - 1);
    }
}

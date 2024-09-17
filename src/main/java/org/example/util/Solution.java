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

        for (int i = 0; i < numbers.length; i++) {
            String stringNumber = String.valueOf(numbers[i]);
            char firstDigit = stringNumber.charAt(0);
            char lastDigit = stringNumber.charAt(stringNumber.length() - 1);

            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    // The same number must be skipped.
                    continue;
                }

                String twinStringNumber = String.valueOf(numbers[j]);
                char twinFirstDigit = twinStringNumber.charAt(0);
                char twinLastDigit = twinStringNumber.charAt(twinStringNumber.length() - 1);

                if (firstDigit == twinFirstDigit && lastDigit == twinLastDigit) {
                    pairs.put(numbers[i], numbers[j]);
                }
            }
        }
        return pairs;
    }
}

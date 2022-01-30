package com.girardsimon.adventofcode2021.problems;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Day1Resolver {

    private final List<String> depths;

    public int[] mapLinesToIntArray() {
        return depths.stream()
                .map(Integer::parseInt).mapToInt(i -> i).toArray();
    }

    public int countNumberOfDepthIncreasing(int windowMeasurementSize) {
        var arrayOfDepths = mapLinesToIntArray();
        int numberOfDepthIncreasing = 0;
        for (int i = 0; i < arrayOfDepths.length- windowMeasurementSize; i++) {
            int firstSum = getSumForWindow(i, windowMeasurementSize);
            int secondSum = getSumForWindow(i+1, windowMeasurementSize);

            if(secondSum > firstSum) {
                numberOfDepthIncreasing++;
            }
        }
        return numberOfDepthIncreasing;
    }

    public int getSumForWindow(int currentIndex, int windowMeasurementSize) {
        var arrayOfDepths = mapLinesToIntArray();
        int sumForWindows = arrayOfDepths[currentIndex];
        for(int i = 1; i < windowMeasurementSize; i++) {
            sumForWindows += arrayOfDepths[currentIndex + i];
        }

        return sumForWindows;
    }
}

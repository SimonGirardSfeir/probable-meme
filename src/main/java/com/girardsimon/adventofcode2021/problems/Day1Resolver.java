package com.girardsimon.adventofcode2021.problems;

import java.util.List;

public class Day1Resolver implements Resolver {

    @Override
    public int part1(List<String> lines) {
        int output = 0;
        int[] intsFromFiles = mapLinesToIntArray(lines);

        for(int i = 0; i < intsFromFiles.length - 1; i++) {
            if (intsFromFiles[i + 1] > intsFromFiles[i]) {
                output++;
            }
        }
        return output;
    }

    @Override
    public int part2(List<String> lines) {
        int output = 0;

        int[] intsFromFiles = mapLinesToIntArray(lines);

        for(int i = 0; i < intsFromFiles.length - 3; i++) {
            int firstSumThreeConsecutives = intsFromFiles[i] + intsFromFiles[i+1]
                    + intsFromFiles[i+2];
            int secondSumThreeConsecutives = intsFromFiles[i+1] + intsFromFiles[i+2]
                    + intsFromFiles[i+3];
            if (secondSumThreeConsecutives > firstSumThreeConsecutives) {
                output++;
            }
        }

        return output;
    }

    private int[] mapLinesToIntArray(List<String> lines) {
        return lines.stream()
                .map(Integer::parseInt).mapToInt(i -> i).toArray();
    }
}

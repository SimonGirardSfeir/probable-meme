package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class Day1Resolver {

    public int part1(String fileName) throws IOException {
        int output = 0;
        int[] intsFromFiles = UtilsClass.getLines(fileName).stream()
                .map(Integer::parseInt).mapToInt(i -> i).toArray();

        for(int i = 0; i < intsFromFiles.length - 1; i++) {
            if (intsFromFiles[i + 1] > intsFromFiles[i]) {
                output++;
            }
        }
        return output;
    }

    public int part2(String fileName) throws IOException {
        int output = 0;

        int[] intsFromFiles = UtilsClass.getLines(fileName).stream()
                .map(Integer::parseInt).mapToInt(i -> i).toArray();

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
}

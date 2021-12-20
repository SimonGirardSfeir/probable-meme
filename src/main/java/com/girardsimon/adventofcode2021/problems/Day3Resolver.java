package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day3.BitPositionData;

import java.util.List;
import java.util.stream.Collectors;

public class Day3Resolver implements Resolver {

    int[] number1PerBit = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] number0PerBit = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    public int part1(List<String> lines) {

        int binaryLength = lines.get(0).length();
        lines.forEach(this::incrementBitCounter);

        StringBuilder gammaRateSb = new StringBuilder();
        StringBuilder epsilonRateSb = new StringBuilder();

        for(int i = 0; i < binaryLength; i++) {
            if(number0PerBit[i] < number1PerBit[i]) {
                gammaRateSb.append("1");
                epsilonRateSb.append("0");
            } else {
                gammaRateSb.append("0");
                epsilonRateSb.append("1");
            }
        }

        int gammaRate = Integer.parseInt(gammaRateSb.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilonRateSb.toString(), 2);

        return gammaRate * epsilonRate;
    }

    @Override
    public int part2(List<String> lines) {
        var oxygenList = lines;
        int i = 0;

        while(oxygenList.size() > 1) {
            List<String> finalOxygenList = oxygenList;
            int finalI = i;
            oxygenList = oxygenList.stream()
                    .filter(line -> line.charAt(finalI) == getMostCommonBitPerPosition(finalOxygenList, finalI))
                    .collect(Collectors.toList());
            i++;
        }

        var c02List = lines;
        int j = 0;

        while(c02List.size() > 1) {
            List<String> finalc02List = c02List;
            int finalJ = j;
            c02List = c02List.stream()
                    .filter(line -> line.charAt(finalJ) != getMostCommonBitPerPosition(finalc02List, finalJ))
                    .collect(Collectors.toList());
            j++;
        }

        int oxygenGenaratorRating = Integer.parseInt(oxygenList.get(0), 2);
        int cO2ScrubberRating = Integer.parseInt(c02List.get(0), 2);

        return oxygenGenaratorRating * cO2ScrubberRating;
    }

    private void incrementBitCounter(String line) {
        for(int j = 0; j < line.length(); j++) {
            if(line.charAt(j) == '1') {
                number1PerBit[j]++;
            } else if(line.charAt(j) == '0') {
                number0PerBit[j]++;
            }
        }
    }

    private char getMostCommonBitPerPosition(List<String> list, int bitPosition) {
        BitPositionData bitPositionData = new BitPositionData(0, 0);

        list.forEach(value -> {
            if (value.charAt(bitPosition) == '1') {
                bitPositionData.incrementOne();
            } else {
                bitPositionData.incrementZeros();
            }
        });

        if(bitPositionData.getNumberOfOnes() >= bitPositionData.getNumberOfZeros()) {
            return '1';
        } else {
            return '0';
        }
    }
}

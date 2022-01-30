package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day3.BitPositionData;

import java.util.List;
import java.util.stream.Collectors;

public class Day3Resolver {

    public char getMostCommonBitForPosition(List<String> binaryNumbers, int bitPosition) {
        BitPositionData bitPositionData = new BitPositionData(0, 0);

        binaryNumbers.forEach(value -> {
            if (value.charAt(bitPosition) == '1') {
                bitPositionData.incrementOne();
            } else {
                bitPositionData.incrementZeros();
            }
        });

        if(bitPositionData.getNumberOfOnes() > bitPositionData.getNumberOfZeros()) {
            return '1';
        } else if (bitPositionData.getNumberOfOnes() < bitPositionData.getNumberOfZeros()){
            return '0';
        } else {
            // For part 1, rule about equality is not clear at all, but hopefully, this case does not append in examples.
            return 'X';
        }
    }

    public int binaryToDecimal(String binaryRepresentation) {
        int decimalNumber = 0;

        for(int i = binaryRepresentation.length() -1; i >= 0; i--) {
            if(binaryRepresentation.charAt(i) == '1') {
                decimalNumber += (int) Math.pow(2, (binaryRepresentation.length() -1 - i));
            }
        }

        return decimalNumber;
    }

    public int getGammaRate(List<String> binaryNumbers) {
        StringBuilder gammaRateSb = new StringBuilder();

        int binaryLength = binaryNumbers.get(0).length();

        for(int i = 0; i < binaryLength; i++) {
            gammaRateSb.append(getMostCommonBitForPosition(binaryNumbers, i));
        }

        return binaryToDecimal(gammaRateSb.toString());
    }

    public int getEpsilonRate(List<String> binaryNumbers) {
        StringBuilder epsilonRateSb = new StringBuilder();

        int binaryLength = binaryNumbers.get(0).length();

        for(int i = 0; i < binaryLength; i++) {
            char input = getMostCommonBitForPosition(binaryNumbers, i) == '1' ? '0' : '1';
            epsilonRateSb.append(input);
        }

        return binaryToDecimal(epsilonRateSb.toString());
    }

    public int getOxygenGeneratorRating(List<String> binaryNumbers) {
        int currentIndex = 0;

        while(binaryNumbers.size() > 1) {
            char mostCommonBitForCurrentPosition = getMostCommonBitForPosition(binaryNumbers, currentIndex) == '0' ? '0' : '1';
            int finalIndex = currentIndex;
            binaryNumbers = binaryNumbers.stream()
                    .filter(binaryNumber ->
                            (binaryNumber.charAt(finalIndex)  == mostCommonBitForCurrentPosition))
                    .collect(Collectors.toList());
            currentIndex++;

        }

        return binaryToDecimal(binaryNumbers.get(0));
    }

    public int getCo2ScrubberRating(List<String> binaryNumbers) {
        int currentIndex = 0;

        while(binaryNumbers.size() > 1) {
            char leastCommonBitForCurrentPosition = getMostCommonBitForPosition(binaryNumbers, currentIndex) != '0' ? '0' : '1';
            int finalIndex = currentIndex;
            binaryNumbers = binaryNumbers.stream()
                    .filter(binaryNumber ->
                            (binaryNumber.charAt(finalIndex)  == leastCommonBitForCurrentPosition))
                    .collect(Collectors.toList());
            currentIndex++;

        }

        return binaryToDecimal(binaryNumbers.get(0));
    }
}

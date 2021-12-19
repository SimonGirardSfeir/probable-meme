package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.ObjectDay3;
import com.girardsimon.adventofcode2021.utils.UtilsClass;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class Day3Resolver {

    int[] number1PerBit = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] number0PerBit = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public int part1(String fileName) throws IOException {

        UtilsClass.getLines(fileName)
                .forEach(Day3Resolver::incrementBitCounter);

        StringBuilder gammaRateSb = new StringBuilder();
        StringBuilder epsilonRateSb = new StringBuilder();

        for(int i = 0; i < 12; i++) {
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

    public int part2(String fileName) throws IOException {
        var oxygenList = UtilsClass.getLines(fileName);
        int i = 0;

        while(oxygenList.size() > 1) {
            List<String> finalOxygenList = oxygenList;
            int finalI = i;
            oxygenList = oxygenList.stream()
                    .filter(line -> line.charAt(finalI) == getMostCommonBitPerPosition(finalOxygenList, finalI))
                    .collect(Collectors.toList());
            i++;
        }

        var c02List = UtilsClass.getLines(fileName);
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
        ObjectDay3 objectDay3 = new ObjectDay3(0, 0);

        list.forEach(value -> {
            if (value.charAt(bitPosition) == '1') {
                objectDay3.incrementOne();
            } else {
                objectDay3.incrementZeros();
            }
        });

        if(objectDay3.getNumberOfOnes() >= objectDay3.getNumberOfZeros()) {
            return '1';
        } else {
            return '0';
        }
    }
}

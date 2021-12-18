package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.DirectionDay2;
import com.girardsimon.adventofcode2021.model.InstructionsDay2;
import com.girardsimon.adventofcode2021.utils.UtilsClass;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.stream.Collectors;

@UtilityClass
public class Day2Resolver {

    public int part1(String fileName) throws IOException {
        int[] finalPosition = new int[]{0, 0};

        var instructionsList = UtilsClass.getLines(fileName).stream()
                .map(value -> InstructionsDay2.builder()
                        .value(Integer.parseInt(value.split(" ")[1]))
                        .direction(DirectionDay2.valueOf(value.split(" ")[0]))
                        .build()
                ).collect(Collectors.toList());

        for (InstructionsDay2 instructionsDay2 : instructionsList) {
            if (instructionsDay2.getDirection().equals(DirectionDay2.up)) {
                finalPosition[1] = finalPosition[1] - instructionsDay2.getValue();
            } else if (instructionsDay2.getDirection().equals(DirectionDay2.down)) {
                finalPosition[1] = finalPosition[1] + instructionsDay2.getValue();
            } else {
                finalPosition[0] = finalPosition[0] + instructionsDay2.getValue();
            }
        }

        return finalPosition[0]*finalPosition[1];
    }

    public int part2(String fileName) throws IOException {
        int[] finalPosition = new int[]{0, 0, 0};

        var instructionsList = UtilsClass.getLines(fileName).stream()
                .map(value -> InstructionsDay2.builder()
                        .value(Integer.parseInt(value.split(" ")[1]))
                        .direction(DirectionDay2.valueOf(value.split(" ")[0]))
                        .build()
                ).collect(Collectors.toList());

        for (InstructionsDay2 instructionsDay2 : instructionsList) {
            if (instructionsDay2.getDirection().equals(DirectionDay2.up)) {
                finalPosition[2] = finalPosition[2] - instructionsDay2.getValue();
            } else if (instructionsDay2.getDirection().equals(DirectionDay2.down)) {
                finalPosition[2] = finalPosition[2] + instructionsDay2.getValue();
            } else {
                finalPosition[0] = finalPosition[0] + instructionsDay2.getValue();
                finalPosition[1] = finalPosition[1] + finalPosition[2]*instructionsDay2.getValue();
            }
        }

        return finalPosition[0]*finalPosition[1];
    }
}

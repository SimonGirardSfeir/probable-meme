package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day2.Direction;
import com.girardsimon.adventofcode2021.model.day2.Instruction;

import java.util.List;
import java.util.stream.Collectors;

public class Day2Resolver implements Resolver{

    @Override
    public int part1(List<String> lines) {
        int[] finalPosition = new int[]{0, 0};

        var instructionsList = getInstructionFromLines(lines);

        for (Instruction instruction : instructionsList) {
            if (instruction.getDirection().equals(Direction.up)) {
                finalPosition[1] = finalPosition[1] - instruction.getValue();
            } else if (instruction.getDirection().equals(Direction.down)) {
                finalPosition[1] = finalPosition[1] + instruction.getValue();
            } else {
                finalPosition[0] = finalPosition[0] + instruction.getValue();
            }
        }

        return finalPosition[0]*finalPosition[1];
    }

    @Override
    public int part2(List<String> lines) {
        int[] finalPosition = new int[]{0, 0, 0};

        var instructionsList = getInstructionFromLines(lines);

        for (Instruction instruction : instructionsList) {
            if (instruction.getDirection().equals(Direction.up)) {
                finalPosition[2] = finalPosition[2] - instruction.getValue();
            } else if (instruction.getDirection().equals(Direction.down)) {
                finalPosition[2] = finalPosition[2] + instruction.getValue();
            } else {
                finalPosition[0] = finalPosition[0] + instruction.getValue();
                finalPosition[1] = finalPosition[1] + finalPosition[2]*instruction.getValue();
            }
        }

        return finalPosition[0]*finalPosition[1];
    }

    private List<Instruction> getInstructionFromLines(List<String> lines) {
        return lines.stream()
                .map(value -> Instruction.builder()
                        .value(Integer.parseInt(value.split(" ")[1]))
                        .direction(Direction.valueOf(value.split(" ")[0]))
                        .build()
                ).collect(Collectors.toList());
    }
}

package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day2.Direction;
import com.girardsimon.adventofcode2021.model.day2.Instruction;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Day2Resolver {

    private final List<String> instructions;

    public List<Instruction> mapLinesToInstructions() {
        return instructions.stream()
                .map(value -> Instruction.builder()
                        .value(Integer.parseInt(value.split(" ")[1]))
                        .direction(Direction.valueOf(value.split(" ")[0]))
                        .build()
                ).collect(Collectors.toList());
    }

    public int computeFinalPositionProduct() {
        int horizontalPosition = 0;
        int depth = 0;

        var instructionsList = mapLinesToInstructions();

        for (Instruction instruction : instructionsList) {
            switch (instruction.getDirection()) {
                case up:
                    depth = depth - instruction.getValue();
                    break;
                case down:
                    depth = depth + instruction.getValue();
                    break;
                case forward:
                    horizontalPosition = horizontalPosition + instruction.getValue();
                    break;
            }
        }

        return depth*horizontalPosition;
    }

    public int computeFinalPositionProductWithAim() {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        var instructionsList = mapLinesToInstructions();

        for (Instruction instruction : instructionsList) {
            switch (instruction.getDirection()) {
                case up:
                    aim = aim - instruction.getValue();
                    break;
                case down:
                    aim = aim + instruction.getValue();
                    break;
                case forward:
                    horizontalPosition = horizontalPosition + instruction.getValue();
                    depth = depth + aim*instruction.getValue();
                    break;
            }

        }

        return depth*horizontalPosition;
    }
}

package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day2.Instruction;
import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.girardsimon.adventofcode2021.model.day2.Direction.down;
import static com.girardsimon.adventofcode2021.model.day2.Direction.forward;
import static com.girardsimon.adventofcode2021.model.day2.Direction.up;
import static org.assertj.core.api.Assertions.assertThat;

class Day2ResolverTest {

    List<String> lines;
    Day2Resolver resolver;
    List<String> linesFromAOC;
    Day2Resolver aOCresolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromAOC = UtilsClass.getLines("src/test/resources/day2/data.txt");
        aOCresolver = new Day2Resolver(linesFromAOC);
        lines = Arrays.asList("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
        resolver = new Day2Resolver(lines);
    }

    @Test
    void mapLinesToInstructions_should_map_lines_to_instruction_with_correct_input() {
        //When
        var actualInstructions = resolver.mapLinesToInstructions();

        //Then
        Instruction i1 = Instruction.builder()
                .direction(forward)
                .value(5)
                .build();
        Instruction i2 = Instruction.builder()
                .direction(down)
                .value(5)
                .build();
        Instruction i3 = Instruction.builder()
                .direction(forward)
                .value(8)
                .build();
        Instruction i4 = Instruction.builder()
                .direction(up)
                .value(3)
                .build();
        Instruction i5 = Instruction.builder()
                .direction(down)
                .value(8)
                .build();
        Instruction i6 = Instruction.builder()
                .direction(forward)
                .value(2)
                .build();
        var expectedInstructions = Arrays.asList(i1, i2, i3, i4, i5, i6);
        assertThat(actualInstructions).containsAll(expectedInstructions);
    }

    @Test
    void computeFinalPositionProduct_should_return_rightResult() {
        //When
        int actualFinalPositionProduct = resolver.computeFinalPositionProduct();

        //Then
        int expectedFinalPositionProduct = 150;
        assertThat(actualFinalPositionProduct).isEqualTo(expectedFinalPositionProduct);
    }

    @Test
    void computeFinalPositionProductWithAim_should_return_rightResult() {
        //When
        int actualFinalPositionProduct = resolver.computeFinalPositionProductWithAim();

        //Then
        int expectedFinalPositionProduct = 900;
        assertThat(actualFinalPositionProduct).isEqualTo(expectedFinalPositionProduct);
    }

    @Test
    void part1_result() {
        //When
        int actualMultiplicationResult = aOCresolver.computeFinalPositionProduct();

        //Then
        int expectedMultiplicationResult = 1694130;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

    @Test
    void part2_result() {
        //When
        int actualMultiplicationResult = aOCresolver.computeFinalPositionProductWithAim();

        //Then
        int expectedMultiplicationResult = 1698850445;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

}
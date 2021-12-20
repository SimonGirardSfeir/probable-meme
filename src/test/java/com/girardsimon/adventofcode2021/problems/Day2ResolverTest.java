package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day2ResolverTest {

    List<String> linesFromFile;
    Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day2/data.txt");
        resolver = new Day2Resolver();
    }

    @Test
    void part1_should_return_the_multiplication_of_depth_times_horizontal_position() {
        //When
        int actualMultiplicationResult = resolver.part1(linesFromFile);

        //Then
        int expectedMultiplicationResult = 1694130;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

    @Test
    void part2_should_return_the_multiplication_of_depth_times_horizontal_position_times_aim() {
        //When
        int actualMultiplicationResult = resolver.part2(linesFromFile);

        //Then
        int expectedMultiplicationResult = 1698850445;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

}
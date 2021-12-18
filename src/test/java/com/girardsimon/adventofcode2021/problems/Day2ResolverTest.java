package com.girardsimon.adventofcode2021.problems;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day2ResolverTest {

    @Test
    void part1_should_return_the_multiplication_of_depth_times_horizontal_position() throws IOException {
        //When
        int actualMultiplicationResult = Day2Resolver.part1("src/test/resources/day2/data.txt");

        //Then
        int expectedMultiplicationResult = 1694130;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

    @Test
    void part2_should_return_the_multiplication_of_depth_times_horizontal_position_times_aim() throws IOException {
        //When
        int actualMultiplicationResult = Day2Resolver.part2("src/test/resources/day2/data.txt");

        //Then
        int expectedMultiplicationResult = 1698850445;
        assertThat(actualMultiplicationResult).isEqualTo(expectedMultiplicationResult);
    }

}
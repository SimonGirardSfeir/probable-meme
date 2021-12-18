package com.girardsimon.adventofcode2021.problems;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day1ResolverTest {

    @Test
    void part1_should_calculate_number_of_times_depth_measurement_increases() throws IOException {
        //When
        int actualNumberOfTimes = Day1Resolver.part1("src/test/resources/day1/data.txt");

        //Then
        int expectedNumberOfTimes = 1288;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

    @Test
    void part2_should_calculate_number_of_times_sums_of_three_consecutives_depth_measurement_increases() throws IOException {
        //When
        int actualNumberOfTimes = Day1Resolver.part2("src/test/resources/day1/data.txt");

        //Then
        int expectedNumberOfTimes = 1311;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

}
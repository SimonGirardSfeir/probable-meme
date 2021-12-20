package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day1ResolverTest {

    List<String> linesFromFile;
    Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day1/data.txt");
        resolver = new Day1Resolver();
    }

    @Test
    void part1_should_calculate_number_of_times_depth_measurement_increases() {
        //When
        int actualNumberOfTimes = resolver.part1(linesFromFile);

        //Then
        int expectedNumberOfTimes = 1288;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

    @Test
    void part2_should_calculate_number_of_times_sums_of_three_consecutives_depth_measurement_increases() {
        //When
        int actualNumberOfTimes = resolver.part2(linesFromFile);

        //Then
        int expectedNumberOfTimes = 1311;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

}
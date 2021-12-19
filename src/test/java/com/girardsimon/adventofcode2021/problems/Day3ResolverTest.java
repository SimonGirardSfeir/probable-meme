package com.girardsimon.adventofcode2021.problems;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day3ResolverTest {

    @Test
    void part1_should_compute_power_consuption() throws IOException {
        //Given
        int actualPowerConsuption = Day3Resolver.part1("src/test/resources/day3/data.txt");

        //Then
        int expectedPowerConsuption = 1307354;
        assertThat(actualPowerConsuption).isEqualTo(expectedPowerConsuption);
    }

    @Test
    void part2_should_compute_life_support_rating() throws IOException {
        //Given
        int actualLifeSupportRating = Day3Resolver.part2("src/test/resources/day3/data.txt");

        //Then
        int expectedLifeSupportRating = 482500;
        assertThat(actualLifeSupportRating).isEqualTo(expectedLifeSupportRating);
    }

}
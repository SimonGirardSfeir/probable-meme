package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day3ResolverTest {

    List<String> linesFromFile;
    Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day3/data.txt");
        resolver = new Day3Resolver();
    }

    @Test
    void part1_should_compute_power_consuption() {
        //Given
        int actualPowerConsuption = resolver.part1(linesFromFile);

        //Then
        int expectedPowerConsuption = 1307354;
        assertThat(actualPowerConsuption).isEqualTo(expectedPowerConsuption);
    }

    @Test
    void part2_should_compute_life_support_rating()  {
        //Given
        int actualLifeSupportRating = resolver.part2(linesFromFile);

        //Then
        int expectedLifeSupportRating = 482500;
        assertThat(actualLifeSupportRating).isEqualTo(expectedLifeSupportRating);
    }

}
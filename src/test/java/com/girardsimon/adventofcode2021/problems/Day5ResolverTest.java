package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day5ResolverTest {

    List<String> linesFromFile;
    Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day5/data.txt");
        resolver = new Day5Resolver();
    }

    @Test
    void part1_should_compute_number_of_points_at_least_two_times_overlaped_only_considering_vertical_and_horizontal_movements() {
        //Given
        int actualNumberOfPointsAtLeastTwoTimesOverlaped = resolver.part1(linesFromFile);

        //Then
        int expectedNumberOfPointsAtLeastTwoTimesOverlaped = 5092;
        assertThat(actualNumberOfPointsAtLeastTwoTimesOverlaped).isEqualTo(expectedNumberOfPointsAtLeastTwoTimesOverlaped);
    }

    @Test
    void part2_should_compute_number_of_points_at_least_two_times_overlaped_considering_all_movements() {
        //Given
        int actualNumberOfPointsAtLeastTwoTimesOverlaped = resolver.part2(linesFromFile);

        //Then
        int expectedNumberOfPointsAtLeastTwoTimesOverlaped = 20484;
        assertThat(actualNumberOfPointsAtLeastTwoTimesOverlaped).isEqualTo(expectedNumberOfPointsAtLeastTwoTimesOverlaped);
    }
}
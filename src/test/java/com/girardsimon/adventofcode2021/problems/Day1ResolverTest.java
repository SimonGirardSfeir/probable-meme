package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day1ResolverTest {

    List<String> linesFromFile;
    Day1Resolver resolver;
    List<String> simpleDataSampleForDepths;
    Day1Resolver resolverWithBasicData;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day1/data.txt");
        resolver = new Day1Resolver(linesFromFile);
        simpleDataSampleForDepths = Arrays.asList("199", "200", "208", "210", "200", "207", "240", "269", "260", "263");
        resolverWithBasicData = new Day1Resolver(simpleDataSampleForDepths);
    }

    @Test
    void mapLinesToIntArray_should_map_List_of_String_to_a_List_of_Integer_if_data_corresponding_to_number() {
        //Given
        var givenList = Arrays.asList("123", "456", "789");
        var givenDay1Resolver = new Day1Resolver(givenList);

        //When
        var actualList = givenDay1Resolver.mapLinesToIntArray();

        //Then
        var expectedList = new int[] {123, 456, 789};
        assertThat(actualList).containsExactly(expectedList);
    }

    @Test
    void mapLinesToIntArray_should_throw_NumberFormatException_if_data_contains_at_least_one_element_which_did_not_match_a_number() {
        //Given
        var givenList = Arrays.asList("123", "Coucou", "789");
        var givenDay1Resolver = new Day1Resolver(givenList);

        //When...Then
        assertThrows(NumberFormatException.class, givenDay1Resolver::mapLinesToIntArray);
    }

    @Test
    void getSumForWindow_should_return_sum_asociated_with_current_index_and_window_size() {
        //Given
        int currentIndex = 0;
        int windowMeasurementSize = 3;

        //When
        int actualSumForWindow = resolverWithBasicData.getSumForWindow(currentIndex, windowMeasurementSize);

        //Then
        int expectedSumForWindow = 607;
        assertThat(actualSumForWindow).isEqualTo(expectedSumForWindow);
    }

    private static Stream<Arguments> inputsForcountNumberOfDepthIncreasing() {
        return Stream.of(
                Arguments.of(1, 7),
                Arguments.of(3, 5)
        );
    }

    @MethodSource("inputsForcountNumberOfDepthIncreasing")
    @ParameterizedTest
    void countNumberOfDepthIncreasing_should_compute_number_of_depth_increasing_according_to_given_sliding_window(int windowMeasurementSize, int expectedNumberOfDepthIncresing) {
        //When
        int actualNumberOfDepthIncreasing = resolverWithBasicData.countNumberOfDepthIncreasing(windowMeasurementSize);

        assertThat(actualNumberOfDepthIncreasing).isEqualTo(expectedNumberOfDepthIncresing);
    }


    /**
     * I keep these unit tests only to conserve my aoc result!
     */
    @Test
    void part1_should_calculate_number_of_times_depth_measurement_increases() {
        //When
        int actualNumberOfTimes = resolver.countNumberOfDepthIncreasing(1);

        //Then
        int expectedNumberOfTimes = 1288;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

    @Test
    void part2_should_calculate_number_of_times_sums_of_three_consecutives_depth_measurement_increases() {
        //When
        int actualNumberOfTimes = resolver.countNumberOfDepthIncreasing(3);

        //Then
        int expectedNumberOfTimes = 1311;
        assertThat(actualNumberOfTimes).isEqualTo(expectedNumberOfTimes);
    }

}
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

class Day3ResolverTest {

    List<String> linesFromAOC;
    List<String> lines;
    Day3Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromAOC = UtilsClass.getLines("src/test/resources/day3/data.txt");
        lines = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111",
                "11100", "10000", "11001", "00010", "01010");
        resolver = new Day3Resolver();
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(0, '1'),
                Arguments.of(1, '0'),
                Arguments.of(2, '1'),
                Arguments.of(3, '1'),
                Arguments.of(4, '0')
        );
    }
    @MethodSource("inputs")
    @ParameterizedTest
    void getMostCommonBitForPosition_should_return_most_common_bit_for_given_position(int givenPosition, char expectedMostCommonBitForPosition) {
        //When
        char actualCommonBitForPosition = resolver.getMostCommonBitForPosition(lines, givenPosition);

        //Then
        assertThat(actualCommonBitForPosition).isEqualTo(expectedMostCommonBitForPosition);
    }

    @Test
    void binaryToDecimal_should_give_decimal_representation_of_given_binary_number(){
        //Given
        String givenBinaryRepresentation = "10110";

        //When
        int actualDecimalRepresentation = resolver.binaryToDecimal(givenBinaryRepresentation);

        //Then
        int expectedDecimalRepresentation = 22;
        assertThat(actualDecimalRepresentation).isEqualTo(expectedDecimalRepresentation);

    }

    @Test
    void getGammaRate_should_compute_GammaRate() {
        //When
        int actualGammaRate = resolver.getGammaRate(lines);

        //Then
        int expectedGammaRate = 22;
        assertThat(actualGammaRate).isEqualTo(expectedGammaRate);
    }

    @Test
    void getEpsilonRate_should_compute_EpsilonRate() {
        //When
        int actualEpsilonRate = resolver.getEpsilonRate(lines);

        //Then
        int expectedEpsilonRate = 9;
        assertThat(actualEpsilonRate).isEqualTo(expectedEpsilonRate);
    }

    @Test
    void getOxygenGeneratorRating_should_computeOxygenGeneratorRating() {
        //When
        int actualOxygenGeneratorRating = resolver.getOxygenGeneratorRating(lines);

        //Then
        int expectedOxygenGeneratorRating = 23;
        assertThat(actualOxygenGeneratorRating).isEqualTo(expectedOxygenGeneratorRating);
    }

    @Test
    void getCo2ScrubberRating_should_computeCo2ScrubberRating() {
        //When
        int actualCo2ScrubberRating = resolver.getCo2ScrubberRating(lines);

        //Then
        int expectedCo2ScrubberRating= 10;
        assertThat(actualCo2ScrubberRating).isEqualTo(expectedCo2ScrubberRating);
    }

    @Test
    void part1_solution() {
        //Given
        int actualPowerConsuption = resolver.getEpsilonRate(linesFromAOC) * resolver.getGammaRate(linesFromAOC);

        //Then
        int expectedPowerConsuption = 1307354;
        assertThat(actualPowerConsuption).isEqualTo(expectedPowerConsuption);
    }


    @Test
    void part2_solution()  {
        //Given
        int actualLifeSupportRating = resolver.getCo2ScrubberRating(linesFromAOC) * resolver.getOxygenGeneratorRating(linesFromAOC);

        //Then
        int expectedLifeSupportRating = 482500;
        assertThat(actualLifeSupportRating).isEqualTo(expectedLifeSupportRating);
    }

}
package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.utils.UtilsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day4ResolverTest {

    List<String> linesFromFile;
    Resolver resolver;

    @BeforeEach
    void setUp() throws IOException {
        linesFromFile = UtilsClass.getLines("src/test/resources/day4/data.txt");
        resolver = new Day4Resolver();
    }

    @Test
    void part1_should_compute_sum_all_unmarked_numbers_times_last_instruction_first_winning_board() {
        //Given
        int actualProduct = resolver.part1(linesFromFile);

        //Then
        int expectedProduct = 60368;
        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void part2_should_compute_sum_all_unmarked_numbers_times_last_instruction_last_winning_board() {
        //Given
        int actualProduct = resolver.part2(linesFromFile);

        //Then
        int expectedProduct = 17435;
        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

}
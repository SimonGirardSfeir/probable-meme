package com.girardsimon.adventofcode2021.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsClassTest {

    @Test
    void getLines_should_return_List_of_strings() throws IOException {
        //Given
        String fileLocation = "src/test/resources/getLinesFileTest.txt";

        //When
        List<String> lines = UtilsClass.getLines(fileLocation);

        //Then
        List<String> expectedLines = Arrays.asList("Bonjour","Au Revoir", "Coucou",
                "Java","Advent Of Code");
        assertThat(lines).hasSameElementsAs(expectedLines);
    }

}
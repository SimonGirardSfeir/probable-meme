package com.girardsimon.adventofcode2021.model.day3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BitPositionData {

    int numberOfZeros;
    int numberOfOnes;

    public void incrementOne() {
        numberOfOnes++;
    }

    public void incrementZeros() {
        numberOfZeros++;
    }
}

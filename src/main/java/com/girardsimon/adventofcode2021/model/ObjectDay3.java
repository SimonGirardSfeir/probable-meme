package com.girardsimon.adventofcode2021.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectDay3 {

    int numberOfZeros;
    int numberOfOnes;

    public void incrementOne() {
        numberOfOnes++;
    }

    public void incrementZeros() {
        numberOfZeros++;
    }
}

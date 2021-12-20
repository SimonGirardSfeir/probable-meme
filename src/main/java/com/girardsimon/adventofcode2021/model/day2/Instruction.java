package com.girardsimon.adventofcode2021.model.day2;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Instruction {

    int value;
    Direction direction;
}

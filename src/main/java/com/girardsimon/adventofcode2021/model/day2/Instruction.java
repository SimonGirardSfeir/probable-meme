package com.girardsimon.adventofcode2021.model.day2;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Instruction {

    int value;
    Direction direction;
}

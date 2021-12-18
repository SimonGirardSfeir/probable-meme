package com.girardsimon.adventofcode2021.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class InstructionsDay2 {

    int value;
    DirectionDay2 direction;
}

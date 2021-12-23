package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day5.Line;
import com.girardsimon.adventofcode2021.model.day5.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day5Resolver implements Resolver {

    @Override
    public int part1(List<String> lines) {

        List<Line> linesData = getLinesFromLines(lines);

        Map<Point, Integer> map = new HashMap<>();

        for(Line line : linesData) {
            var coveredPoints = line.getHorizontallyCoveredPoints();
            coveredPoints.addAll(line.getVerticallyCoveredPoints());

            for(Point point : coveredPoints) {
                if(map.containsKey(point)) {
                    map.put(point, map.get(point) + 1);
                } else {
                    map.put(point, 1);
                }
            }
        }

        var mapWithPointAtLeastTwoTimesOverlaped = map.entrySet()
                .stream().filter( point -> point.getValue() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return mapWithPointAtLeastTwoTimesOverlaped.size();
    }

    @Override
    public int part2(List<String> lines) {
        List<Line> linesData = getLinesFromLines(lines);

        Map<Point, Integer> map = new HashMap<>();

        for(Line line : linesData) {

            var coveredPoints = line.getHorizontallyCoveredPoints();
            coveredPoints.addAll(line.getVerticallyCoveredPoints());
            coveredPoints.addAll(line.getXEqYDiagonallyCoveredPoints());
            coveredPoints.addAll(line.getXEqMinusYDiagonallyCoveredPoints());

            for(Point point : coveredPoints) {
                if(map.containsKey(point)) {
                    map.put(point, map.get(point) + 1);
                } else {
                    map.put(point, 1);
                }
            }
        }

        var mapWithPointAtLeastTwoTimesOverlaped = map.entrySet()
                .stream().filter( point -> point.getValue() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return mapWithPointAtLeastTwoTimesOverlaped.size();
    }

    private List<Line> getLinesFromLines(List<String> lines) {
        List<Line> output = new ArrayList<>();
        for(String s: lines) {
            String[] array = s.split(" -> ");

            int[] dataPointStart = Arrays.stream(array[0].split(",")).map(Integer::parseInt).mapToInt(i ->i).toArray();

            Point pointStart = Point.builder()
                    .x(dataPointStart[0])
                    .y(dataPointStart[1])
                    .build();
            int[] dataPointEnd = Arrays.stream(array[1].split(",")).map(Integer::parseInt).mapToInt(i ->i).toArray();

            Point pointEnd = Point.builder()
                    .x(dataPointEnd[0])
                    .y(dataPointEnd[1])
                    .build();

            Line line = Line.builder()
                    .pointStart(pointStart)
                    .pointEnd(pointEnd)
                    .build();

            output.add(line);
        }

        return output;
    }
}

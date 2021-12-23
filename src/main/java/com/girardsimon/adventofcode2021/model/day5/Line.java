package com.girardsimon.adventofcode2021.model.day5;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Line {

    Point pointStart;
    Point pointEnd;

    public List<Point> getHorizontallyCoveredPoints() {
        List<Point> coveredPoints = new ArrayList<>();

        if(pointStart.getY().equals(pointEnd.getY()) && pointStart.getX() > pointEnd.getX()) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValue = pointToAdd.getX() - 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValue)
                        .build();
            }
            coveredPoints.add(pointEnd);
        } else if(pointStart.getY().equals(pointEnd.getY()) && pointStart.getX() < pointEnd.getX()) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValue = pointToAdd.getX() + 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValue)
                        .build();
            }
            coveredPoints.add(pointEnd);
        }

        return coveredPoints;
    }

    public List<Point> getVerticallyCoveredPoints() {
        List<Point> coveredPoints = new ArrayList<>();

        if(pointStart.getX().equals(pointEnd.getX()) && pointStart.getY() < pointEnd.getY()) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValue = pointToAdd.getY()+ 1;
                pointToAdd = pointToAdd.toBuilder()
                        .y(incrementedValue)
                        .build();
            }
            coveredPoints.add(pointEnd);
        } else if(pointStart.getX().equals(pointEnd.getX()) && pointStart.getY() > pointEnd.getY()) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValue = pointToAdd.getY() - 1;
                pointToAdd = pointToAdd.toBuilder()
                        .y(incrementedValue)
                        .build();
            }
            coveredPoints.add(pointEnd);
        }

        return coveredPoints;
    }

    public List<Point> getXEqYDiagonallyCoveredPoints() {
        List<Point> coveredPoints = new ArrayList<>();

        if(((pointEnd.getY() - pointStart.getY()) == (pointEnd.getX() - pointStart.getX()))  &&
                ((pointEnd.getY() - pointStart.getY()) > 0)) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValueX = pointToAdd.getX() + 1;
                int incrementedValueY = pointToAdd.getY() + 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValueX)
                        .y(incrementedValueY)
                        .build();
            }
            coveredPoints.add(pointEnd);
        } else if(((pointEnd.getY() - pointStart.getY()) == (pointEnd.getX() - pointStart.getX()))  &&
                ((pointEnd.getY() - pointStart.getY()) < 0)) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValueX = pointToAdd.getX() - 1;
                int incrementedValueY = pointToAdd.getY() - 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValueX)
                        .y(incrementedValueY)
                        .build();
            }
            coveredPoints.add(pointEnd);
        }

        return coveredPoints;
    }

    public List<Point> getXEqMinusYDiagonallyCoveredPoints() {
        List<Point> coveredPoints = new ArrayList<>();

        if(((pointEnd.getY() - pointStart.getY()) == - (pointEnd.getX() - pointStart.getX()))  &&
                ((pointEnd.getY() - pointStart.getY()) > 0)) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValueX = pointToAdd.getX() - 1;
                int incrementedValueY = pointToAdd.getY() + 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValueX)
                        .y(incrementedValueY)
                        .build();
            }
            coveredPoints.add(pointEnd);
        } else if(((pointEnd.getY() - pointStart.getY()) == - (pointEnd.getX() - pointStart.getX())) &&
                ((pointEnd.getY() - pointStart.getY()) < 0)) {
            Point pointToAdd = pointStart;

            while(!pointToAdd.equals(pointEnd)){
                coveredPoints.add(pointToAdd);

                int incrementedValueX = pointToAdd.getX() + 1;
                int incrementedValueY = pointToAdd.getY() - 1;
                pointToAdd = pointToAdd.toBuilder()
                        .x(incrementedValueX)
                        .y(incrementedValueY)
                        .build();
            }
            coveredPoints.add(pointEnd);
        }

        return coveredPoints;
    }
}

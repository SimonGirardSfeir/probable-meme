package com.girardsimon.adventofcode2021.model.day4;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Bingo {

    final int[][] bingoNumber;
    final boolean[][] markedNumbers;
    final int lastInstruction;

    public boolean hasMarkedLineOrColumn() {

        for(int i = 0; i < 5; i++){

            if(markedNumbers[i][0] && markedNumbers[i][1] && markedNumbers[i][2] && markedNumbers[i][3] && markedNumbers[i][4]) {
                return true;
            }

            if(markedNumbers[0][i] && markedNumbers[1][i] && markedNumbers[2][i] && markedNumbers[3][i] && markedNumbers[4][i]) {
                return true;
            }
        }

        return false;
    }

    public void markANumber(int number) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(bingoNumber[i][j] == number) {
                    markedNumbers[i][j] = true;
                }
            }
        }
    }

    public int sumUnmarkedNumbers() {
        int count = 0;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!markedNumbers[i][j]) {
                    count += bingoNumber[i][j];
                }
            }
        }

        return count;
    }

    public int getLastInstruction() {
        return lastInstruction;
    }
}

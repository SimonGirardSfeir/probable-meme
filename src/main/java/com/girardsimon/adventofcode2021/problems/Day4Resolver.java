package com.girardsimon.adventofcode2021.problems;

import com.girardsimon.adventofcode2021.model.day4.Bingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Resolver implements Resolver {

    @Override
    public int part1(List<String> lines) {

        var instructions = getInstructionFromLine(lines.get(0));

        List<Bingo> bingos = getBingosFromLines(lines);

        var winner = bingoWinner(bingos, instructions);

        return winner.getLastInstruction() * winner.sumUnmarkedNumbers();
    }

    @Override
    public int part2(List<String> lines) {

        var instructions = getInstructionFromLine(lines.get(0));

        List<Bingo> bingos = getBingosFromLines(lines);

        var lastWinner = bingoLastWinner(bingos, instructions);

        return lastWinner.getLastInstruction() * lastWinner.sumUnmarkedNumbers();

    }

    private int[] getInstructionFromLine(String line) {
        return Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private List<Bingo> getBingosFromLines(List<String> lines) {
        List<Bingo> bingos = new ArrayList<>();

        for(int i = 2; i < lines.size() - 4; i += 6) {

            int[][] bingoNumbersToAdd = new int[5][5];
            boolean[][] markedNumbers = new boolean[5][5];

            bingoNumbersToAdd[0] = Arrays.stream(lines.get(i).trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
            bingoNumbersToAdd[1] = Arrays.stream(lines.get(i+1).trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
            bingoNumbersToAdd[2] = Arrays.stream(lines.get(i+2).trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
            bingoNumbersToAdd[3] = Arrays.stream(lines.get(i+3).trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
            bingoNumbersToAdd[4] = Arrays.stream(lines.get(i+4).trim().replace("  ", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

            Bingo bingo = Bingo.builder()
                    .bingoNumber(bingoNumbersToAdd)
                    .markedNumbers(markedNumbers)
                    .build();

            bingos.add(bingo);
        }

        return bingos;
    }

    private Bingo bingoWinner(List<Bingo> bingos, int[] instructions) {

        Bingo winningBingo = null;
        int i = 0;
        int lastInstruction = 0;

        while(winningBingo == null) {
            int finalI = i;
            bingos.forEach(bingoDay4 -> bingoDay4.markANumber(instructions[finalI]));

            winningBingo = bingos.stream().filter(Bingo::hasMarkedLineOrColumn).findFirst().orElse(null);
            lastInstruction = instructions[finalI];
            i++;

        }

        return winningBingo.toBuilder().lastInstruction(lastInstruction).build();
    }

    private Bingo bingoLastWinner(List<Bingo> bingos, int[] instructions) {

        List<Bingo> lastWinningBingo = new ArrayList<>();
        int i = 0;
        int lastInstruction = 0;

        while(i < instructions.length || !bingos.isEmpty()) {
            int finalI = i;
            bingos.forEach(bingoDay4 -> bingoDay4.markANumber(instructions[finalI]));

            var winningBingos = bingos.stream().filter(Bingo::hasMarkedLineOrColumn).collect(Collectors.toList());
            if(!lastWinningBingo.containsAll(winningBingos)) {
                lastWinningBingo = winningBingos;
                lastInstruction = instructions[finalI];
            }
            bingos.removeAll(winningBingos);
            i++;

        }

        return lastWinningBingo.get(0).toBuilder().lastInstruction(lastInstruction).build();
    }
}

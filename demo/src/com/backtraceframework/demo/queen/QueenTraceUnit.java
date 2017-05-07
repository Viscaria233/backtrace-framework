package com.backtraceframework.demo.queen;

import com.backtraceframework.api.TraceUnit;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenTrackUnit implements TraceUnit<Integer[][]> {

    private int row;
    private int column = -1;

    QueenTrackUnit(int row) {
        this.row = row;
    }

    @Override
    public boolean hasNextCase(Integer[][] storage) {
        return column + 1 < storage[row].length;
    }

    @Override
    public void nextCase() {
        column++;
    }

    @Override
    public boolean tryCase(Integer[][] storage) {
        if (hasConflict(storage, row, column)) {
            return false;
        }
        storage[row][column] = 1;
        return true;
    }

    @Override
    public void rollback(Integer[][] storage) {
        storage[row][column] = 0;
    }

    private boolean hasConflict(Integer[][] board, int row, int column) {
        int sum = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (i == row
                        || j == column
                        || i + j == row + column
                        || i - j == row - column) {
                    sum += board[i][j];
                }
            }
        }
        return sum != 0;
    }
}

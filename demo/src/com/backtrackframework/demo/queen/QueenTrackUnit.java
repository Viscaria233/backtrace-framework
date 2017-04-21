package com.backtrackframework.demo.queen;

import com.backtrackframework.api.Storage;
import com.backtrackframework.api.TrackUnit;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenTrackUnit implements TrackUnit {

    private int row;
    private int column = -1;

    QueenTrackUnit(int row) {
        this.row = row;
    }

    @Override
    public boolean hasNextCase(Storage storage) {
        int[][] board = (int[][]) storage.get();
        return column + 1 < board[row].length;
    }

    @Override
    public void nextCase() {
        column++;
    }

    @Override
    public boolean tryCase(Storage storage) {
        int[][] board = (int[][]) storage.get();
        if (hasConflict(board, row, column)) {
            return false;
        }
        board[row][column] = 1;
        return true;
    }

    @Override
    public void rollback(Storage storage) {
        int[][] board = (int[][]) storage.get();
        board[row][column] = 0;
    }

    private boolean hasConflict(int[][] board, int row, int column) {
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

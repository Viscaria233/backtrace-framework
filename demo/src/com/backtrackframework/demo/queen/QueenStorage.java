package com.backtrackframework.demo.queen;

import com.backtrackframework.api.Storage;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenStorage implements Storage {
    private int[][] board;

    QueenStorage(int queenCount) {
        board = new int[queenCount][queenCount];
    }

    @Override
    public Object get() {
        return board;
    }
}

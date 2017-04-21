package com.backtrackframework.demo.queen;

import com.backtrackframework.api.ResultHandler;
import com.backtrackframework.api.Storage;
import com.backtrackframework.api.TrackUnit;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenResultHandler implements ResultHandler {
    @Override
    public void onResultFound(int index, Storage storage, Collection<TrackUnit> units) {
        int[][] board = (int[][]) storage.get();
        System.out.println("---------------------------" + index);
        Arrays.stream(board).forEach(row -> {
            Arrays.stream(row).forEach(i ->
                    System.out.print(i == 0 ? "┼" : "●"));
            System.out.println();
        });
        System.out.println();
    }
}

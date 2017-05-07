package com.backtraceframework.demo.queen;

import com.backtraceframework.api.ResultHandler;
import com.backtraceframework.api.TraceUnit;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenResultHandler implements ResultHandler<Integer[][]> {
    @Override
    public void onResultFound(int index, Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        System.out.println("---------------------------" + index);
        Arrays.stream(storage).forEach(row -> {
            Arrays.stream(row).forEach(i ->
                    System.out.print(i == 0 ? "┼" : "●"));
            System.out.println();
        });
        System.out.println();
    }
}

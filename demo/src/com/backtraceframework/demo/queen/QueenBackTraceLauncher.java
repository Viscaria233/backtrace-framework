package com.backtraceframework.demo.queen;

import com.backtraceframework.api.BackTracer;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenBackTraceLauncher {
    public static void launch() {
        int queenCount = 8;
        int count = new BackTracer<Integer[][]>()
                .setStorage(squareArray(queenCount))
                .setTraceUnitIterator(new QueenIterator(queenCount))
                .setResultHandler(new QueenResultHandler())
                .setExitDecider(new QueenExitDecider())
                .launch();
        System.out.println(count + " result(s) found.");
    }

    private static Integer[][] squareArray(int length) {
        Integer[][] array = new Integer[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                array[i][j] = 0;
            }
        }
        return array;
    }
}

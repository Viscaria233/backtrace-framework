package com.backtraceframework.demo.queen;

import com.backtraceframework.api.BackTracer;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenBackTrackLauncher {
    public static void launch() {
        int queenCount = 8;
        int count = new BackTracer<Integer[][]>()
                .setTraceUnitIterator(new QueenIterator(queenCount))
                .setResultHandler(new QueenResultHandler())
                .setExitDecider(new QueenExitDecider())
                .launch();
        System.out.println(count + " result(s) found.");
    }
}

package com.backtrackframework.demo.queen;

import com.backtrackframework.api.BackTracker;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenBackTrackLauncher {
    public static void launch() {
        int queenCount = 8;
        int count = new BackTracker()
                .setStorage(new QueenStorage(queenCount))
                .setTrackUnitIterator(new QueenIterator(queenCount))
                .setResultHandler(new QueenResultHandler())
                .setExitDecider(new QueenExitDecider())
                .launch();
        System.out.println(count + " result(s) found.");
    }
}

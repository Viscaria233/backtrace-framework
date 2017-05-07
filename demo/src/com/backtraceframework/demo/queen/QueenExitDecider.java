package com.backtraceframework.demo.queen;

import com.backtraceframework.api.ExitDecider;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenExitDecider implements ExitDecider {
    @Override
    public boolean shouldExit(int index) {
        return false;
    }
}

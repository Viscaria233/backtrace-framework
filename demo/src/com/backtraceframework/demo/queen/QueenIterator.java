package com.backtraceframework.demo.queen;

import com.backtraceframework.api.TraceUnit;
import com.backtraceframework.api.TraceUnitIterator;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenIterator implements TraceUnitIterator<Integer[][]> {
    private int queenCount;

    QueenIterator(int queenCount) {
        this.queenCount = queenCount;
    }

    @Override
    public boolean hasNext(Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        return units.size() < queenCount;
    }

    @Override
    public TraceUnit<Integer[][]> next(Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        return new QueenTraceUnit(units.size());
    }
}

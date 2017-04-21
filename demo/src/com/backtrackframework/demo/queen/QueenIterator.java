package com.backtrackframework.demo.queen;

import com.backtrackframework.api.Storage;
import com.backtrackframework.api.TrackUnit;
import com.backtrackframework.api.TrackUnitIterator;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class QueenIterator implements TrackUnitIterator {
    private int queenCount;

    QueenIterator(int queenCount) {
        this.queenCount = queenCount;
    }

    @Override
    public boolean hasNext(Storage storage, Collection<TrackUnit> units) {
        return units.size() < queenCount;
    }

    @Override
    public TrackUnit next(Storage storage, Collection<TrackUnit> units) {
        return new QueenTrackUnit(units.size());
    }
}

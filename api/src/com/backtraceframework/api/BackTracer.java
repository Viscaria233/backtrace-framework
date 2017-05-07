package com.backtrackframework.api;

import java.util.Stack;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * 回溯算法的主体<br/>
 * 先调用以下几个方法，最后调用{@link BackTracker#launch()}启动算法
 * <br/>
 * @see BackTracker#setStorage(Storage)
 * @see BackTracker#setTrackUnitIterator(TrackUnitIterator)
 * @see BackTracker#setResultHandler(ResultHandler)
 * @see BackTracker#setExitDecider(ExitDecider)
 */
public final class BackTracker<Storage> {

    /**
     * 用来存储数据，比如八皇后中的棋盘，迷宫问题中的迷宫
     */
    private Storage storage;

    /**
     * 所有回溯单元组成的迭代器<br/>
     */
    private TrackUnitIterator<Storage> trackUnitIterator;

    /**
     * 结果处理器，用来处理找到的结果，比如保存或输出显示<br/>
     */
    private ResultHandler<Storage> resultHandler;

    /**
     * 结束判定器，找到结果时用来判断是否应该结束算法<br/>
     */
    private ExitDecider exitDecider;

    /**
     * @see BackTracker
     */
    public BackTracker() {}

    /**
     * 启动回溯算法<br/>
     * <br/>
     * @return 找到的结果数量，若没找到则返回0，初始化错误则返回-1
     */
    public int launch() {
        if (storage == null
                || trackUnitIterator == null
                || exitDecider == null) {
            return -1;
        }

        Stack<TrackUnit<Storage>> units = new Stack<>();
        if (!trackUnitIterator.hasNext(storage, units)) {
            return 0;
        }

        units.push(trackUnitIterator.next(storage, units));
        int count = 0;

        while (!units.isEmpty()) {
            TrackUnit<Storage> peek = units.peek();
            if (peek.hasNextCase(storage)) {
                peek.nextCase();
                if (peek.tryCase(storage)) {
                    if (trackUnitIterator.hasNext(storage, units)) {
                        units.push(trackUnitIterator.next(storage, units));
                    } else {
                        count++;
                        if (resultHandler != null) {
                            resultHandler.onResultFound(count, storage, units);
                        }
                        if (exitDecider.shouldExit(count)) {
                            return count;
                        } else {
                            peek.rollback(storage);
                        }
                    }
                }
            } else {
                units.pop();
                if (!units.isEmpty()) {
                    units.peek().rollback(storage);
                }
            }
        }
        return count;
    }

    /**
     * 调用{@link BackTracker#launch()}之前，
     * 必须设置存储数据
     * @see Storage
     */
    public BackTracker<Storage> setStorage(Storage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * 调用{@link BackTracker#launch()}之前，
     * 必须设置迭代器
     * @see TrackUnitIterator
     */
    public BackTracker<Storage> setTrackUnitIterator(TrackUnitIterator<Storage> trackUnitIterator) {
        this.trackUnitIterator = trackUnitIterator;
        return this;
    }

    /**
     * 调用{@link BackTracker#launch()}之前，
     * 可以设置结果处理器<br/>
     * 可以显示或保存结果
     * @see ResultHandler
     */
    public BackTracker<Storage> setResultHandler(ResultHandler<Storage> resultHandler) {
        this.resultHandler = resultHandler;
        return this;
    }

    /**
     * 调用{@link BackTracker#launch()}之前，
     * 必须设置结束判定器
     * @see ExitDecider
     */
    public BackTracker<Storage> setExitDecider(ExitDecider exitDecider) {
        this.exitDecider = exitDecider;
        return this;
    }
}

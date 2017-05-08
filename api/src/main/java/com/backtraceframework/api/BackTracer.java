package com.backtraceframework.api;

import java.util.Stack;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * 回溯算法的主体<br/>
 * 先调用以下几个方法，最后调用{@link BackTracer#launch()}启动算法
 * <br/>
 * @see BackTracer#setStorage(Storage)
 * @see BackTracer#setTraceUnitIterator(TraceUnitIterator)
 * @see BackTracer#setResultHandler(ResultHandler)
 * @see BackTracer#setExitDecider(ExitDecider)
 */
public final class BackTracer<Storage> {

    /**
     * 用来存储数据，比如八皇后中的棋盘，迷宫问题中的迷宫
     */
    private Storage storage;

    /**
     * 所有回溯单元组成的迭代器<br/>
     */
    private TraceUnitIterator<Storage> traceUnitIterator;

    /**
     * 结果处理器，用来处理找到的结果，比如保存或输出显示<br/>
     */
    private ResultHandler<Storage> resultHandler;

    /**
     * 结束判定器，找到结果时用来判断是否应该结束算法<br/>
     */
    private ExitDecider exitDecider;

    /**
     * @see BackTracer
     */
    public BackTracer() {}

    /**
     * 启动回溯算法<br/>
     * <br/>
     * @return 找到的结果数量，若没找到则返回0，初始化错误则返回-1
     */
    public int launch() {
        if (storage == null
                || traceUnitIterator == null
                || exitDecider == null) {
            return -1;
        }

        Stack<TraceUnit<Storage>> units = new Stack<>();
        if (!traceUnitIterator.hasNext(storage, units)) {
            return 0;
        }

        units.push(traceUnitIterator.next(storage, units));
        int count = 0;

        while (!units.isEmpty()) {
            TraceUnit<Storage> peek = units.peek();
            if (peek.hasNextCase(storage)) {
                peek.nextCase();
                if (peek.tryCase(storage)) {
                    if (traceUnitIterator.hasNext(storage, units)) {
                        units.push(traceUnitIterator.next(storage, units));
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
     * 调用{@link BackTracer#launch()}之前，
     * 必须设置存储数据
     * @see Storage
     */
    public BackTracer<Storage> setStorage(Storage storage) {
        this.storage = storage;
        return this;
    }

    /**
     * 调用{@link BackTracer#launch()}之前，
     * 必须设置迭代器
     * @see TraceUnitIterator
     */
    public BackTracer<Storage> setTraceUnitIterator(TraceUnitIterator<Storage> traceUnitIterator) {
        this.traceUnitIterator = traceUnitIterator;
        return this;
    }

    /**
     * 调用{@link BackTracer#launch()}之前，
     * 可以设置结果处理器<br/>
     * 可以显示或保存结果
     * @see ResultHandler
     */
    public BackTracer<Storage> setResultHandler(ResultHandler<Storage> resultHandler) {
        this.resultHandler = resultHandler;
        return this;
    }

    /**
     * 调用{@link BackTracer#launch()}之前，
     * 必须设置结束判定器
     * @see ExitDecider
     */
    public BackTracer<Storage> setExitDecider(ExitDecider exitDecider) {
        this.exitDecider = exitDecider;
        return this;
    }
}

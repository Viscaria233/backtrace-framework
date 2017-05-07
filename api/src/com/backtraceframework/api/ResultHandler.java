package com.backtrackframework.api;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * 回溯算法找到结果时会调用{@link ResultHandler#onResultFound(int, Storage, Collection)}，
 * 可以在这里保存或输出结果<br/>
 */
public interface ResultHandler<Storage> {
    /**
     * 找到结果时会被调用，保存或输出结果<br/>
     * 之后会调用{@link ExitDecider#shouldExit(int)}，判断是否应该停止算法
     * @param index 这是第几个结果
     * @param storage 可能会用到
     * @param units 可能会用到
     */
    void onResultFound(int index, Storage storage, Collection<TrackUnit<Storage>> units);
}

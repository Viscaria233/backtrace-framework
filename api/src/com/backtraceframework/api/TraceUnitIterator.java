package com.backtraceframework.api;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * {@link TrackUnit}的迭代器<br/>
 * 用{@link TrackUnitIterator#hasNext(Storage, Collection)}判断是否有下一个<br/>
 * 用{@link TrackUnitIterator#next(Storage, Collection)}获取下一个，
 * 一般应该创建一个新的 <code>TrackUnit</code> 对象<br/>
 */
public interface TrackUnitIterator<Storage> {
    /**
     * 判断是否有下一个{@link TrackUnit}
     * @param storage 存储的数据<br/>
     *                比如: 马遍历棋盘问题中，storage里是一个用 <code>int[][]</code> 表示的棋盘<br/>
     *                当 <code>units.size() ==<br/>
     *                &nbsp;&nbsp;&nbsp;&nbsp;((int[][]) storage.get()).length<br/>
     *                &nbsp;&nbsp;&nbsp;&nbsp;* ((int[][]) storage.get())[0].length</code><br/>
     *                即棋盘上所有位置都被走过时返回<code>false</code><br/>
     * @return 是否有下一个 <code>TrackUnit</code>
     */
    boolean hasNext(Storage storage, Collection<TrackUnit<Storage>> units);

    /**
     * @param storage 可能会用到
     * @param units 可能会用到
     * @return 下一个 <code>TrackUnit</code>
     */
    TrackUnit<Storage> next(Storage storage, Collection<TrackUnit<Storage>> units);
}

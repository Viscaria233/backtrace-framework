package com.backtraceframework.api;

/**
 * Created by Haochen on 2017/4/10.
 * <br/><br/>
 * 回溯算法的单元，比如：<br/>
 * 八皇后问题用回溯法解决，其中回溯单元是皇后，一共有8个单元。<br/>
 * 马遍历棋盘问题中，回溯单元是马走的每一步，一共有很多个单元<br/>
 * 迷宫问题中，回溯单元是迷宫里的人走的每一步，一共有很多个单元<br/>
 * <br/>
 * 用{@link TrackUnit#hasNextCase(Storage)}判断是否可以向前探测<br/>
 * 用{@link TrackUnit#nextCase()}移动到探测的位置<br/>
 * 用{@link TrackUnit#tryCase(Storage)}尝试向前探测<br/>
 * 不能向前探测时用{@link TrackUnit#rollback(Storage)}恢复探测中被改变的数据
 *
 */
public interface TrackUnit<Storage> {
    /**=
     * @return 是否可以向前探测
     */
    boolean hasNextCase(Storage storage);

    /**
     * 移动到下一个探测的位置
     */
    void nextCase();

    /**
     * 尝试向前探测
     * @param storage 存储的数据
     * @return 是否成功
     */
    boolean tryCase(Storage storage);

    /**
     * 当{@link TrackUnit#hasNextCase(Storage)}返回 <code>false</code> 时，
     * 恢复在{@link TrackUnit#tryCase(Storage)}中被改变的数据
     * @param storage 存储的数据
     */
    void rollback(Storage storage);
}

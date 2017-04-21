package com.backtrackframework.api;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * 用来存储数据，比如八皇后中的棋盘，迷宫问题中的迷宫<br/>
 * 所有数据必须封装在一个类对象中，用{@link Storage#get()}获取
 */
public interface Storage {
    /**
     * @return 存储的数据
     */
    Object get();
}

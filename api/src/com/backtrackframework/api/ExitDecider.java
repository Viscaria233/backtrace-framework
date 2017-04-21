package com.backtrackframework.api;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * <br/>
 * <br/>
 * {@link ResultHandler#onResultFound(int, Storage, Collection)}被调用后，
 * 紧接着会调用{@link ExitDecider#shouldExit(int)}，判断是否应该停止算法
 */
public interface ExitDecider {
    /**
     * 紧接在{@link ResultHandler#onResultFound(int, Storage, Collection)}之后被调用，判断是否应该停止算法<br/>
     * @return 只需找到一种结果: <code>true</code><br/>
     * 需要找到所有结果: <code>false</code><br/>
     * 需要找到n种结果: 设置一个 <code>int count = 0</code> 用来给结果计数，<br/>
     * 当 <code>count >= n</code> 时返回 <code>true</code>，否则返回<code>false</code>
     * @param index 目前找到了多少个结果
     */
    boolean shouldExit(int index);
}

package cn.cstube.service;

import cn.cstube.pojo.Setmeal;

/**
 * @auther heling
 * @date 2021/7/17
 */
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
}

package cn.cstube.dao;

import cn.cstube.pojo.CheckGroup;

import java.util.Map;

/**
 * @auther heling
 * @date 2021/7/11
 */
public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);
    public void setCheckGroupAndCheckItem(Map map);
}

package cn.cstube.dao;

import cn.cstube.pojo.CheckGroup;
import com.github.pagehelper.Page;

import java.util.Map;

/**
 * @auther heling
 * @date 2021/7/11
 */
public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);
    public void setCheckGroupAndCheckItem(Map map);

    public Page<CheckGroup> findByCondition(String queryString);
}

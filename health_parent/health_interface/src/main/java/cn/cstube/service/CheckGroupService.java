package cn.cstube.service;

import cn.cstube.entity.PageResult;
import cn.cstube.entity.QueryPageBean;
import cn.cstube.pojo.CheckGroup;

/**
 * @auther heling
 * @date 2021/7/11
 */
public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);

    public PageResult pageQuery(QueryPageBean queryPageBean);
}

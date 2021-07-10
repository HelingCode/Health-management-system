package cn.cstube.service;

import cn.cstube.entity.PageResult;
import cn.cstube.entity.QueryPageBean;
import cn.cstube.pojo.CheckItem;

//服务接口
public interface CheckItemService {
    public void add(CheckItem checkItem);

    public PageResult pageQuery(QueryPageBean queryPageBean);



}

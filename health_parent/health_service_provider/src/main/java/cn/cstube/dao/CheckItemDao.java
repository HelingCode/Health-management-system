package cn.cstube.dao;


import cn.cstube.entity.PageResult;
import cn.cstube.entity.QueryPageBean;
import cn.cstube.pojo.CheckItem;
import com.github.pagehelper.Page;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    public Page<CheckItem> selectByCondition(String queryString);



}

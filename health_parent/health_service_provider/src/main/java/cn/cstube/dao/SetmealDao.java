package cn.cstube.dao;

import cn.cstube.pojo.CheckGroup;
import cn.cstube.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @auther heling
 * @date 2021/7/11
 */
public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map map);




}

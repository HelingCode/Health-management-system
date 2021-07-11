package cn.cstube.service.impl;

import cn.cstube.pojo.CheckGroup;
import cn.cstube.service.CheckGroupService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther heling
 * @date 2021/7/11
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    //新增检查组，同时需要让检查组关联检查项
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        //新增检查组，操作t_checkgroup

        //设置检查组和检查项的多对多的关联关系，操作t_checkgroup_checkitem表
    }
}

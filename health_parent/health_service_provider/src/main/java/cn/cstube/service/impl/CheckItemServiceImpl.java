package cn.cstube.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.cstube.dao.CheckItemDao;
import cn.cstube.entity.PageResult;
import cn.cstube.entity.QueryPageBean;
import cn.cstube.pojo.CheckItem;
import cn.cstube.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    //注入DAO对象
    @Autowired
    private CheckItemDao checkItemDao;

    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }


    //检查项分页查询
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        //完成分页查询，基于mybatis框架提供的分页助手插件完成
        PageHelper.startPage(currentPage,pageSize);

        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();

        return new PageResult(total,rows);

    }

    //根据id来删除检查项
    public void deleteById(Integer id) {
        //判断一下当前检查项是否已经关联到检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //当前检查项已经被关联到检查组，不允许删除
            new RuntimeException();
        }

        checkItemDao.deleteById(id);
    }


    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }


    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }


}

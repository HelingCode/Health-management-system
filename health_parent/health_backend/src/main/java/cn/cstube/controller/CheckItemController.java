package cn.cstube.controller;

import cn.cstube.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.cstube.constant.MessageConstant;
import cn.cstube.entity.PageResult;
import cn.cstube.entity.QueryPageBean;
import cn.cstube.entity.Result;
import cn.cstube.pojo.CheckItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 检查项管理
 */

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;


    //新增检查项
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){

        try{
            checkItemService.add(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return  new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    //检查项分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return checkItemService.pageQuery(queryPageBean);
    }


    //删除检查项
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try{
            checkItemService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
        }

        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);

    }

    //编辑检查项
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try{
            checkItemService.edit(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }

        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);

    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            CheckItem checkItem = checkItemService.findById(id);
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }


}

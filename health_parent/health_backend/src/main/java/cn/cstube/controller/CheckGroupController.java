package cn.cstube.controller;

import cn.cstube.constant.MessageConstant;
import cn.cstube.entity.Result;
import cn.cstube.pojo.CheckGroup;
import cn.cstube.pojo.CheckItem;
import cn.cstube.service.CheckGroupService;
import cn.cstube.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther heling
 * @date 2021/7/11
 * 检查组管理
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;

    //新增检查组
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){

        try{
            checkGroupService.add(checkGroup,checkitemIds);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return  new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
}

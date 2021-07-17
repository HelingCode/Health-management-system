package cn.cstube.controller;

import cn.cstube.constant.MessageConstant;
import cn.cstube.entity.Result;
import cn.cstube.pojo.Setmeal;
import cn.cstube.service.SetmealService;
import cn.cstube.utils.QiniuUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamSource;

import java.io.IOException;
import java.util.UUID;

/**
 * @auther heling
 * @date 2021/7/17
 * 体检套餐管理
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    //文件上传
    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile){
        System.out.println(imgFile);

        String originalFilename1 = imgFile.getOriginalFilename();
        int index = originalFilename1.lastIndexOf(".");
        String extention = originalFilename1.substring(index - 1);
        String fileName = UUID.randomUUID().toString() + extention;

        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true,MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
    }
    @Reference
    private SetmealService sermealService;

    //新增套餐
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){

        try {
            sermealService.add(setmeal,checkgroupIds);
        } catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }

        return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
    }
}

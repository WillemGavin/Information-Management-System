package io.volunteer.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import io.volunteer.modules.app.annotation.Login;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.volunteer.modules.app.entity.ExamEntity;
import io.volunteer.modules.app.service.ExamService;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.R;



/**
 * 
 *
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:41
 */
@RestController
@RequestMapping("/volunteer/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("/list")
    @ApiOperation("获取试题信息")
//    @RequiresPermissions("volunteer:exam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @RequestMapping("/info/{examId}")
//    @RequiresPermissions("volunteer:exam:info")
    public R info(@PathVariable("examId") Integer examId){
		ExamEntity exam = examService.getById(examId);

        return R.ok().put("exam", exam);
    }

    /**
     * 保存
     */
    @Login
    @RequestMapping("/save")
    @RequiresPermissions("volunteer:exam:save")
    public R save(@RequestBody ExamEntity exam){
		examService.save(exam);

        return R.ok();
    }

    /**
     * 修改
     */
    @Login
    @RequestMapping("/update")
    @RequiresPermissions("volunteer:exam:update")
    public R update(@RequestBody ExamEntity exam){
		examService.updateById(exam);

        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
    @RequiresPermissions("volunteer:exam:delete")
    public R delete(@RequestBody Integer[] examIds){
		examService.removeByIds(Arrays.asList(examIds));

        return R.ok();
    }

}

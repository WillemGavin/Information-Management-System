package io.volunteer.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.volunteer.modules.app.entity.AnswerEntity;
import io.volunteer.modules.app.service.AnswerService;
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
@RequestMapping("/volunteer/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:answer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = answerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{examId}")
    @RequiresPermissions("app:answer:info")
    public R info(@PathVariable("examId") Integer examId){
		AnswerEntity answer = answerService.getById(examId);

        return R.ok().put("answer", answer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:answer:save")
    public R save(@RequestBody AnswerEntity answer){
		answerService.save(answer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:answer:update")
    public R update(@RequestBody AnswerEntity answer){
		answerService.updateById(answer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:answer:delete")
    public R delete(@RequestBody Integer[] examIds){
		answerService.removeByIds(Arrays.asList(examIds));

        return R.ok();
    }

}

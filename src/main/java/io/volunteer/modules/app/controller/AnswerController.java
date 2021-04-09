package io.volunteer.modules.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.volunteer.modules.app.service.RankService;
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

    @Autowired
    private RankService rankService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("volunteer:answer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = answerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{examId}")
    @RequiresPermissions("volunteer:answer:info")
    public R info(@PathVariable("examId") Integer examId){
		AnswerEntity answer = answerService.getById(examId);

        return R.ok().put("answer", answer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("volunteer:answer:save")
    public R save(@RequestBody List<AnswerEntity> answers){
        for (AnswerEntity answer: answers) {
            answerService.saveAnswer(answer);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("volunteer:answer:update")
    public R update(@RequestBody AnswerEntity answer){
		answerService.updateById(answer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("volunteer:answer:delete")
    public R delete(@RequestBody Integer[] answerIds){
		answerService.removeByIds(Arrays.asList(answerIds));

        return R.ok();
    }

    @RequestMapping("/personRank")
    public R personRank(){
        return R.ok().put("rank", rankService.getPersonalRank());
    }

    @RequestMapping("/teamRank")
    public R teamRank(){
        return R.ok().put("rank", rankService.getTeamRank());
    }
}

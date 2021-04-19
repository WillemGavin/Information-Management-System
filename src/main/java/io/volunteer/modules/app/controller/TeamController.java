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

import io.volunteer.modules.app.entity.TeamEntity;
import io.volunteer.modules.app.service.TeamService;
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
@RequestMapping("/volunteer/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("volunteer:team:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teamService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teamId}")
//    @RequiresPermissions("volunteer:team:info")
    public R info(@PathVariable("teamId") Integer teamId){
		TeamEntity team = teamService.getById(teamId);

        return R.ok().put("team", team);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("volunteer:team:save")
    public R save(@RequestBody TeamEntity team){
		teamService.save(team);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("volunteer:team:update")
    public R update(@RequestBody TeamEntity team){
		teamService.updateById(team);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("volunteer:team:delete")
    public R delete(@RequestBody Integer[] teamIds){
		teamService.removeByIds(Arrays.asList(teamIds));

        return R.ok();
    }

}

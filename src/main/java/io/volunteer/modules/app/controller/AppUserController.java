package io.volunteer.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.volunteer.modules.app.entity.AppUserEntity;
import io.volunteer.modules.app.service.AppUserService;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.R;



/**
 * 用户
 *
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:42
 */
@RestController
@RequestMapping("volunteer/appuser")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("volunteer:appuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
//    @RequiresPermissions("volunteer:appuser:info")
    public R info(@PathVariable("userId") Long userId){
		AppUserEntity appUser = appUserService.getById(userId);

        return R.ok().put("appUser", appUser);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
//    @RequiresPermissions("volunteer:appuser:save")
    public R save(@RequestBody AppUserEntity appUser){
		appUserService.saveOrUpdate(appUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("volunteer:appuser:update")
    public R update(@RequestBody AppUserEntity appUser){
		appUserService.updateById(appUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("volunteer:appuser:delete")
    public R delete(@RequestBody Long[] userIds){
		appUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}

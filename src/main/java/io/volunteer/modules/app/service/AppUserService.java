package io.volunteer.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.modules.app.entity.AppUserEntity;
import io.volunteer.modules.app.form.LoginForm;

import java.util.Map;

/**
 * 用户
 *
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:42
 */
public interface AppUserService extends IService<AppUserEntity> {

    PageUtils queryPage(Map<String, Object> params);


    AppUserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     * @param form    登录表单
     * @return        返回用户ID
     */
    long login(AppUserEntity appUserEntity);

    /**
     * 计算参与此活动的人数
     * @param taskId
     * @return
     */
    long countBytask(int taskId);
}


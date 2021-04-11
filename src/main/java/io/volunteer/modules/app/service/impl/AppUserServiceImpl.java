package io.volunteer.modules.app.service.impl;

import io.volunteer.common.validator.Assert;
import io.volunteer.modules.app.entity.UserEntity;
import io.volunteer.modules.app.form.LoginForm;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.Query;

import io.volunteer.modules.app.dao.AppUserDao;
import io.volunteer.modules.app.entity.AppUserEntity;
import io.volunteer.modules.app.service.AppUserService;


@Service("appUserService")
public class AppUserServiceImpl extends ServiceImpl<AppUserDao, AppUserEntity> implements AppUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppUserEntity> page = this.page(
                new Query<AppUserEntity>().getPage(params),
                new QueryWrapper<AppUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public AppUserEntity queryByOpenId(String openId) {
        return baseMapper.selectOne(new QueryWrapper<AppUserEntity>().eq("openId", openId));
    }

    @Override
    public long login(String openId) {
        AppUserEntity user = queryByOpenId(openId);
        Assert.isNull(user, "用户不存在");
        return user.getUserId();
    }


}
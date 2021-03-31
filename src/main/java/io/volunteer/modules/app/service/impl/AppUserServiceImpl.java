package io.volunteer.modules.app.service.impl;

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

}
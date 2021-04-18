package io.volunteer.modules.app.service.impl;

import io.volunteer.common.exception.RRException;
import io.volunteer.common.validator.Assert;
import io.volunteer.modules.app.entity.UserEntity;
import io.volunteer.modules.app.form.LoginForm;
import io.volunteer.modules.app.service.TaskService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private  AppUserDao appUserDao;

    @Autowired
    private TaskService taskService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppUserEntity> page = this.page(
                new Query<AppUserEntity>().getPage(params),
                new QueryWrapper<AppUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public AppUserEntity queryByMobile(String mobile) {
        return this.getOne(new QueryWrapper<AppUserEntity>().eq("mobile", mobile));
    }

    @Override
    public long countBytask(int taskId){
        return appUserDao.countBytask(taskId);
    }

    @Override
    public long login(AppUserEntity appUserEntity) {
        if(appUserEntity.getUsername() == null){
            throw new RRException("用户名为空");
        }
        if(appUserEntity.getMobile() == null){
            throw new RRException("联系方式为空");
        }
        if(appUserEntity.getTeamId() == null){
            throw new RRException("所属团队为空");
        }

        AppUserEntity oldUser = this.queryByMobile(appUserEntity.getMobile());
        if(oldUser == null){
            long num = this.countBytask(1);
            if(num >= taskService.getById(1).getPaticipantesNum()){
                throw  new RRException("人数已超过上限");
            }
            this.saveOrUpdate(appUserEntity);
            oldUser = this.queryByMobile(appUserEntity.getMobile());
        }
        else if(!oldUser.getUsername().equals(appUserEntity.getUsername())){
            throw new RRException("手机号已被绑定");
        }

        return oldUser.getUserId();
    }


}
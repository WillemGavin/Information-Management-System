package io.volunteer.modules.app.dao;

import io.volunteer.modules.app.entity.AppUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:42
 */
@Mapper
public interface AppUserDao extends BaseMapper<AppUserEntity> {
	
}

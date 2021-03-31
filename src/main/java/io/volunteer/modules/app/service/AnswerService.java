package io.volunteer.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.modules.app.entity.AnswerEntity;

import java.util.Map;

/**
 * 
 *
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:41
 */
public interface AnswerService extends IService<AnswerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package io.volunteer.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.Query;

import io.volunteer.modules.app.dao.AnswerDao;
import io.volunteer.modules.app.entity.AnswerEntity;
import io.volunteer.modules.app.service.AnswerService;


@Service("answerService")
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, AnswerEntity> implements AnswerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnswerEntity> page = this.page(
                new Query<AnswerEntity>().getPage(params),
                new QueryWrapper<AnswerEntity>()
        );

        return new PageUtils(page);
    }

}
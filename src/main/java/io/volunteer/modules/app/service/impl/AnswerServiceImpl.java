package io.volunteer.modules.app.service.impl;

import io.volunteer.modules.app.entity.ExamEntity;
import io.volunteer.modules.app.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ExamService examService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnswerEntity> page = this.page(
                new Query<AnswerEntity>().getPage(params),
                new QueryWrapper<AnswerEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean saveAnswer(AnswerEntity answer) {
        ExamEntity standardAnswer = examService.getById(answer.getExamId());

        if (standardAnswer.getExamType() == 2) {
            //如果此题为填空题
            answer.setGrade(standardAnswer.getExamGrade());
        } else if (standardAnswer.getStandardAnswer().equals(answer.getExamAnswer())) {
            //答案一致
            answer.setGrade(standardAnswer.getExamGrade());
        } else {
            //答案不一致
            answer.setGrade(0);
        }

        AnswerEntity baseAnswer = new AnswerEntity();
        baseAnswer.setExamId(answer.getExamId());
        baseAnswer.setUserId(answer.getUserId());
        AnswerEntity oldAnswer = this.getOne(new QueryWrapper<AnswerEntity>(baseAnswer));
        if (oldAnswer == null)
            return this.save(answer);
        else
            answer.setAnswerId(oldAnswer.getAnswerId());
        return this.updateById(answer);
    }
}
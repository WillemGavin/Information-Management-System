package io.volunteer.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.Query;
import io.volunteer.modules.app.dao.RankDao;
import io.volunteer.modules.app.entity.AnswerEntity;
import io.volunteer.modules.app.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RankServiceImpl
 * Description TODO
 * @Author WillemGavin
 * @Date 2021/4/9 14:48
 * Version 0.0.1
 */
@Service("rankService")
public class RankServiceImpl implements RankService {

    @Autowired
    private RankDao rankDao;

    @Override
    public List<Map> getPersonalRank() {
        return rankDao.getPersonalRank();
    }

    @Override
    public List<Map> getTeamRank() {
        return rankDao.getTeamRank();
    }
}

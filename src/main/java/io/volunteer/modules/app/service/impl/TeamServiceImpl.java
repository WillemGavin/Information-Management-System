package io.volunteer.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.volunteer.common.utils.PageUtils;
import io.volunteer.common.utils.Query;

import io.volunteer.modules.app.dao.TeamDao;
import io.volunteer.modules.app.entity.TeamEntity;
import io.volunteer.modules.app.service.TeamService;


@Service("teamService")
public class TeamServiceImpl extends ServiceImpl<TeamDao, TeamEntity> implements TeamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TeamEntity> page = this.page(
                new Query<TeamEntity>().getPage(params),
                new QueryWrapper<TeamEntity>()
        );

        return new PageUtils(page);
    }

}
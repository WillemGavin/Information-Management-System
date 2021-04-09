package io.volunteer.modules.app.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName rankDao
 * Description TODO
 * @Author WillemGavin
 * @Date 2021/4/9 14:41
 * Version 0.0.1
 */
@Mapper
public interface RankDao {

    List<Map> getPersonalRank();

    List<Map> getTeamRank();
}

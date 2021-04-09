package io.volunteer.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.volunteer.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RankService
 * Description TODO
 * @Author WillemGavin
 * @Date 2021/4/9 14:45
 * Version 0.0.1
 */
public interface RankService {

    List<Map> getPersonalRank();

    List<Map> getTeamRank();
}

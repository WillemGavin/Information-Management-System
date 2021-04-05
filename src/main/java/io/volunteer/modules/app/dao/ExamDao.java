package io.volunteer.modules.app.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.volunteer.modules.app.entity.ExamEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:41
 */
@Mapper
public interface ExamDao extends BaseMapper<ExamEntity> {
    /**
    * @Description: TODO 自定义getpage
    * @Param: [page]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<io.volunteer.modules.app.entity.ExamEntity>
    * @Author: WillemGavin
    * @Date: 2021/4/5 13:59
    */
	IPage<ExamEntity> getPage(IPage<ExamEntity> page);
}

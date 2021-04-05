package io.volunteer.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author WillemGavin
 * @email wangg20@fudan.edu.cn
 * @date 2021-03-31 16:12:41
 */
@Data
@TableName("volunteer_team")
public class TeamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 团队id
	 */
	@TableId
	private Integer teamId;
	/**
	 * 团队名称
	 */
	private String teamName;
	/**
	 * 活动id
	 */
	private Integer taskId;
	/**
	 * 活动名称
	 */
	private String taskName;
}

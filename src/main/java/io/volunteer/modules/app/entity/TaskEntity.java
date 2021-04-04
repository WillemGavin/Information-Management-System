package io.volunteer.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Time;
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
@TableName("volunteer_task")
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务id
	 */
	@TableId
	private Integer taskId;
	/**
	 * 活动名称
	 */
	private String taskName;
	/**
	 * 所读数据url
	 */
	private String bookUrl;
	/**
	 * 注意事项
	 */
	private String tips;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 参与最大人数
	 */
	private Integer paticipantesNum;

}

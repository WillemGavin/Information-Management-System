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
@TableName("volunteer_exam")
public class ExamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 题目id
	 */
	@TableId
	private Integer examId;
	/**
	 * 题目排序
	 */
	private Integer examRank;
	/**
	 * 测试题题目
	 */
	private String examTitle;
	/**
	 * 测试题类型，0 单选； 1 多选， 2 填空题
	 */
	private Integer examType;
	/**
	 * 题目分值
	 */
	private Integer examGrade;
	/**
	 * 题目选项
	 */
	private String examOptions;
	/**
	 * 标准答案
	 */
	private String standardAnswer;
	/**
	 * 活动id
	 */
	private Integer taskId;
	/**
	 * 活动Name
	 */
	private String taskName;
}

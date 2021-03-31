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
@TableName("volunteer_answer")
public class AnswerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 题目id
	 */
	@TableId
	private Integer examId;
	/**
	 * 题目回答
	 */
	private String examAnswer;
	/**
	 * 本题得分
	 */
	private Integer grade;

}

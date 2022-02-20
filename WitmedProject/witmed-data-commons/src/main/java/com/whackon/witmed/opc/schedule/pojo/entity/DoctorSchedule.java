package com.whackon.witmed.opc.schedule.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 医生坐诊实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("opc_doctor_schedule")
public class DoctorSchedule extends BaseEntity {
	private static final long serialVersionUID = 526948567085517603L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "dept")
	private String dept;                    // 科室信息
	@TableField(value = "doctor")
	private String doctor;                  // 医生信息
	@TableField(value = "beginTime")
	private Date beginTime;                 // 坐诊开始时间
	@TableField(value = "endTime")
	private Date endTime;                   // 坐诊结束时间
	@TableField(value = "totalNum")
	private Integer totalNum;               // 今日接诊总数量
	@TableField(value = "usedNum")
	private Integer usedNum;                // 已挂号数量
	@TableField(value = "surplusNum")
	private Integer surplusNum;            // 剩余挂号数量
}

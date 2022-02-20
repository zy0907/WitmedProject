package com.whackon.witmed.emr.resume.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.emr.resume.pojo.entity.Resume;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Repository("resumeDao")
public interface ResumeDao extends BaseMapper<Resume> {
}

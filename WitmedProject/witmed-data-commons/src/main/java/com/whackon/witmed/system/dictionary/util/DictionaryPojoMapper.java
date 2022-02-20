package com.whackon.witmed.system.dictionary.util;

import com.whackon.witmed.system.dictionary.pojo.entity.Education;
import com.whackon.witmed.system.dictionary.pojo.entity.Identity;
import com.whackon.witmed.system.dictionary.pojo.vo.EducationVO;
import com.whackon.witmed.system.dictionary.pojo.vo.IdentityVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据字典 POJO 转换工具</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface DictionaryPojoMapper {
	DictionaryPojoMapper INSTANCE = Mappers.getMapper(DictionaryPojoMapper.class);

	/**
	 * <b>将视图信息转换为实体信息</b>
	 * @param vo
	 * @return
	 */
	Identity parseToEntityForIdentity(IdentityVO vo);

	/**
	 * <b>将实体信息转换为视图信息</b>
	 * @param entity
	 * @return
	 */
	IdentityVO parseToVOForIdentity(Identity entity);

	/**
	 * <b>将实体列表转换为视图列表</b>
	 * @param entityList
	 * @return
	 */
	List<IdentityVO> parseToVOListForIdentity(List<Identity> entityList);

	/**
	 * <b>将视图信息转换为实体信息</b>
	 * @param vo
	 * @return
	 */
	Education parseToEntityForEducation(EducationVO vo);

	/**
	 * <b>将实体信息转换为视图信息</b>
	 * @param entity
	 * @return
	 */
	EducationVO parseToVOForEducation(Education entity);

	/**
	 * <b>将实体列表转换为视图列表</b>
	 * @param entityList
	 * @return
	 */
	List<EducationVO> parseToVOListForEducation(List<Education> entityList);
}

package com.whackon.witmed.util;

import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <b>实体与视图转换工具类</b>
 *
 * @author zyuan
 * @date 2022/1/6
 * @version 1.0.0
 * @since 1.0.0
 */
//mapstruct 中的注解 @Mapper(componentModel = "spring") 转换生成的对象会被Spring容器所管理
@Mapper(componentModel = "spring")
public interface PojoMapper {
	PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);

	/**
	 * <b>将实体对象转换为视图对象</b>
	 * @param entity
	 * @return
	 */
	AdminVO parseToVO(Admin entity);
}

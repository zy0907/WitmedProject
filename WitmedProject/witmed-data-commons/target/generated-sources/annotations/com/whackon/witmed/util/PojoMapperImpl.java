package com.whackon.witmed.util;

import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO.Meta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-19T21:41:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class PojoMapperImpl implements PojoMapper {

    @Override
    public AdminVO parseToVO(Admin entity) {
        if ( entity == null ) {
            return null;
        }

        AdminVO adminVO = new AdminVO();

        adminVO.setRoleVO( adminToRoleVO( entity ) );
        adminVO.setStatus( entity.getStatus() );
        adminVO.setCreatedTime( entity.getCreatedTime() );
        adminVO.setModifiedTime( entity.getModifiedTime() );
        adminVO.setId( entity.getId() );
        adminVO.setNo( entity.getNo() );
        adminVO.setName( entity.getName() );
        adminVO.setCellphone( entity.getCellphone() );
        adminVO.setPassword( entity.getPassword() );
        adminVO.setIdentity( entity.getIdentity() );
        adminVO.setDepartment( entity.getDepartment() );
        adminVO.setTechPostTitle( entity.getTechPostTitle() );
        adminVO.setEducation( entity.getEducation() );
        adminVO.setTechPostRank( entity.getTechPostRank() );

        return adminVO;
    }

    @Override
    public RouterVO parseToRouterVOFromMenu(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        RouterVO routerVO = new RouterVO();

        routerVO.setMeta( menuToMeta( menu ) );
        routerVO.setName( menu.getName() );
        routerVO.setPath( menu.getPath() );
        routerVO.setComponent( menu.getComponent() );

        return routerVO;
    }

    @Override
    public List<RouterVO> parseToRouterVOListFromMenuList(List<Menu> menuList) {
        if ( menuList == null ) {
            return null;
        }

        List<RouterVO> list = new ArrayList<RouterVO>( menuList.size() );
        for ( Menu menu : menuList ) {
            list.add( parseToRouterVOFromMenu( menu ) );
        }

        return list;
    }

    protected RoleVO adminToRoleVO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        RoleVO roleVO = new RoleVO();

        roleVO.setCode( admin.getRole() );

        return roleVO;
    }

    protected Meta menuToMeta(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        Meta meta = new Meta();

        meta.setTitle( menu.getTitle() );
        meta.setIcon( menu.getIcon() );

        return meta;
    }
}

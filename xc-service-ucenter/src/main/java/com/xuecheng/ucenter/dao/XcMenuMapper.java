package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XcMenuMapper{
    //根据id查询用户权限
    List<XcMenu> selectPermissionByUserId(String id);
}

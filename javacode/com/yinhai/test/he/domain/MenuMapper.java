package com.yinhai.test.he.domain;
import com.yinhai.test.he.entity.MenuEntity;

/**
* 描述：描述描述 服务接口
* @author Wuhy
* @date 2018/05/14
*/
public interface MenuMapper {

    MenuEntity findMenuById(String id)throws Exception;
    MenuEntity createMenu(MenuEntity menuEntity) throws Exception;
    void deleteMenu(String id) throws Exception;
    MenuEntity updateMenu(MenuEntity menuEntity) throws Exception;

}
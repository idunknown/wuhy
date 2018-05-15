package com.yinhai.test.he.service.impl;
import com.yinhai.test.he.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yinhai.test.he.entity.MenuEntity;
import com.yinhai.test.he.domain.MenuMapper;
import com.yinhai.sysframework.service.BaseService;
import javax.annotation.Resource;

/**
* 描述：描述描述 服务实现层
* @author Wuhy
* @date 2018/05/14
*/
@Service
public class MenuServiceImpl extends BaseService  implements MenuService  {

  
    @Resource
    private MenuMapper menuMapper;



    @Override
    public MenuEntity findMenuById(String id) throws Exception {
        MenuEntity menuEntity = menuMapper.findMenuById(id);
        return menuEntity;
    }

    @Override
    public MenuEntity createMenu(MenuEntity menuEntity) throws Exception {
         return menuMapper.createMenu(menuEntity);
    }
    @Override
    public void deleteMenu(String id) throws Exception{
        menuMapper.deleteMenu(id);
    }

    @Override
    public MenuEntity updateMenu(MenuEntity menuEntity) throws Exception{
        return  menuMapper.updateMenu(menuEntity);
    }

}
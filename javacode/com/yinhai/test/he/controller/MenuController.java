package com.yinhai.test.he.controller;
import com.yinhai.webframework.BaseAction;
import  com.yinhai.test.he.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yinhai.test.he.entity.MenuEntity;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import com.yinhai.sysframework.dto.ParamDTO;
import com.yinhai.sysframework.util.ValidateUtil;
/**
* 描述：描述描述控制层
* @author Wuhy
* @date 2018/05/14
*/
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseAction{

    @Resource(name = "menuService")
    private MenuService menuService;

    /**
     * 页面
     * @return 页面地址
     */
    @RequestMapping("/toMenuIndex.do")
    public String toExaminationJsp(){
        return "/myjsp/menu/index";
    }

    /**
     * 获取单条数据 by id
     * @return
     */
    @RequestMapping("/toMenuIndex!getOneMenuEntity.do")
    public String getOneMenuEntity(){
        ParamDTO dto = getDto();
        Object id=dto.get("id");
        if(ValidateUtil.isEmpty(id)){
            setMsg("传入参数错误!","ERROR");
            return JSON;
        }
        try{
           MenuEntity   menuEntity  = menuService.findMenuById(id.toString());
           setData(menuEntity.toMap(),true);
        }catch (Exception e){
            e.printStackTrace();
            setMsg("系统异常!","ERROR");
            return JSON;
        }

        return JSON;
    }

    /**
     * 增加数据
     * @return
     */
    @RequestMapping("/toMenuIndex!createMenu.do")
    public String createMenu(){
        ParamDTO dto = getDto();
        MenuEntity menuEntity = new MenuEntity(dto);
        try{
            menuService.createMenu( menuEntity);
         }catch (Exception e){
            e.printStackTrace();
            setMsg("系统异常!","ERROR");
            return JSON;
        }
        setMsg("新增成功!","SUCCUSS");
        return JSON;
    }
     /**
     * 删除单条数据
     * @return
     */
    @RequestMapping("/toMenuIndex!deleteMenu.do")
    public String deleteMenu(){
        ParamDTO dto = getDto();
        Object id=dto.get("id");
        if(ValidateUtil.isEmpty(id)){
            setMsg("传入参数错误!","ERROR");
            return JSON;
        }
        try{
          menuService.deleteMenu(id.toString());
           setData("删除成功!",true);
        }catch (Exception e){
            e.printStackTrace();
            setMsg("系统异常!","ERROR");
            return JSON;
        }
        return JSON;
    }

    /**
     * 增加数据
     * @return
     */
    @RequestMapping("/toMenuIndex!updateMenu.do")
    public String updateMenu(){
        ParamDTO dto = getDto();
        MenuEntity menuEntity = new MenuEntity(dto);
        try{
        menuService.updateMenu( menuEntity);
         }catch (Exception e){
            e.printStackTrace();
            setMsg("系统异常!","ERROR");
            return JSON;
        }
        setMsg("修改成功!","SUCCUSS");
        return JSON;
    }





}

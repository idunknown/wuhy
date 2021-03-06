package ${package_name}.controller;
import com.yinhai.webframework.BaseAction;
import  ${package_name}.service.${table_name!}Service;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import ${package_name!}.entity.${table_name!}Entity;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import com.yinhai.sysframework.dto.ParamDTO;
import com.yinhai.sysframework.util.ValidateUtil;
/**
* 描述：${table_annotation!}控制层
* @author ${author!}
* @date ${date!}
*/
@Controller
@RequestMapping("/${table_name_small!}")
public class ${table_name!}Controller extends BaseAction{

    @Resource(name = "${table_name_small!}Service")
    private ${table_name!}Service ${table_name_small!}Service;

    /**
     * 页面
     * @return 页面地址
     */
    @RequestMapping("/to${table_name!}Index.do")
    public String toExaminationJsp(){
        return "${jsp_file_path!}/${table_name_small!}/index";
    }

    /**
     * 获取单条数据 by id
     * @return
     */
    @RequestMapping("/to${table_name!}Index!getOne${table_name!}Entity.do")
    public String getOne${table_name!}Entity(){
        ParamDTO dto = getDto();
        Object id=dto.get("id");
        if(ValidateUtil.isEmpty(id)){
            setMsg("传入参数错误!","ERROR");
            return JSON;
        }
        try{
           ${table_name}Entity   ${table_name_small}Entity  = ${table_name_small!}Service.find${table_name}ById(id.toString());
           setData(${table_name_small}Entity.toMap(),true);
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
    @RequestMapping("/to${table_name!}Index!create${table_name}.do")
    public String create${table_name}(){
        ParamDTO dto = getDto();
        ${table_name}Entity ${table_name?uncap_first}Entity = new ${table_name}Entity(dto);
        try{
            ${table_name_small!}Service.create${table_name}( ${table_name?uncap_first}Entity);
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
    @RequestMapping("/to${table_name!}Index!delete${table_name!}.do")
    public String delete${table_name!}(){
        ParamDTO dto = getDto();
        Object id=dto.get("id");
        if(ValidateUtil.isEmpty(id)){
            setMsg("传入参数错误!","ERROR");
            return JSON;
        }
        try{
          ${table_name_small!}Service.delete${table_name!}(id.toString());
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
    @RequestMapping("/to${table_name!}Index!update${table_name}.do")
    public String update${table_name}(){
        ParamDTO dto = getDto();
        ${table_name}Entity ${table_name?uncap_first}Entity = new ${table_name}Entity(dto);
        try{
        ${table_name_small!}Service.update${table_name}( ${table_name?uncap_first}Entity);
         }catch (Exception e){
            e.printStackTrace();
            setMsg("系统异常!","ERROR");
            return JSON;
        }
        setMsg("修改成功!","SUCCUSS");
        return JSON;
    }





}

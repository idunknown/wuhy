package ${package_name}.service.impl;
import ${package_name}.service.${table_name}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package_name!}.entity.${table_name!}Entity;
import ${package_name!}.domain.${table_name!}Mapper;
import com.yinhai.sysframework.service.BaseService;

/**
* 描述：${table_annotation} 服务实现层
* @author ${author}
* @date ${date}
*/
@Service
public class ${table_name}ServiceImpl extends BaseService  implements ${table_name}Service  {

  
    @Resource
    private ${table_name!}Mapper ${table_name_small!}Mapper;



    @Override
    public ${table_name}Entity find${table_name!}ById(String id) throws Exception {
        ${table_name}Entity ${table_name?uncap_first}Entity = ${table_name?uncap_first}Mapper.find${table_name!}ById(id);
        return ${table_name?uncap_first}Entity;
    }

    @Override
    public ${table_name}Entity create${table_name}(${table_name}Entity ${table_name?uncap_first}Entity) throws Exception {
         return ${table_name?uncap_first}Mapper.create${table_name!}(${table_name?uncap_first}Entity);
    }
    @Override
    public void delete${table_name!}(String id) throws Exception{
        ${table_name?uncap_first}Mapper.delete${table_name!}(id);
    }

    @Override
    public ${table_name!}Entity update${table_name!}(${table_name!}Entity ${table_name!?uncap_first}Entity) throws Exception{
        return null;
    }

}
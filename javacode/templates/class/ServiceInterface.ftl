package ${package_name!}.service;
import com.yinhai.sysframework.service.BaseService;


/**
* 描述：${table_annotation} 服务接口
* @author ${author!}
* @date ${date!}
*/
public interface ${table_name!}Service extends BaseService {

    ${table_name}Entity find${table_name}ById(String id)throws Exception;
    ${table_name}Entity create${table_name!}(${table_name!}Entity ${table_name?uncap_first}Entity) throws Exception;
    void delete${table_name!}(String id) throws Exception;
    ${table_name!}Entity update${table_name!}(${table_name!}Entity ${table_name!?uncap_first}Entity) throws Exception;

}
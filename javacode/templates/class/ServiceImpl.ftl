package ${package_name}.service.impl;
import ${package_name}.service.${table_name}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package_name}.Entity.${table_name}Entity;
import org.apache.commons.beanutils.BeanUtils;
import com.evada.inno.core.enums.StatusEnum;

/**
* 描述：${table_annotation} 服务实现层
* @author ${author}
* @date ${date}
*/
@Service
public class ${table_name}ServiceImpl  implements ${table_name}Service {

  



    @Override
    public ${table_name}Entity findEntityById(String id) throws Exception {
${table_name}Entity ${table_name?uncap_first}Entity = ${table_name?uncap_first}DAO.findEntityById(id);
        return ${table_name?uncap_first}Entity;
    }

    @Override
    public ${table_name}Entity create${table_name}(${table_name}Entity ${table_name?uncap_first}Entity) throws Exception {
${table_name} ${table_name?uncap_first} = new ${table_name}();
        BeanUtils.copyProperties(${table_name?uncap_first},${table_name?uncap_first}Entity);
${table_name?uncap_first}.setStatus(StatusEnum.ENABLE.toString());
${table_name?uncap_first} = ${table_name?uncap_first}Repository.saveAndFlush(${table_name?uncap_first});
        return this.findEntityById(${table_name?uncap_first}.getId());
    }

    @Override
    public ${table_name}Entity update${table_name}(${table_name}Entity ${table_name?uncap_first}Entity)throws Exception {
${table_name} ${table_name?uncap_first} = new ${table_name}();
        BeanUtils.copyProperties(${table_name?uncap_first},${table_name?uncap_first}Entity);
${table_name?uncap_first} = ${table_name?uncap_first}Repository.saveAndFlush(${table_name?uncap_first});
        return this.findEntityById(${table_name?uncap_first}.getId());
    }
}
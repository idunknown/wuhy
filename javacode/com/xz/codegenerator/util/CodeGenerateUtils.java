package com.xz.codegenerator.util;


import com.xz.codegenerator.entity.ClassEntity;
import com.xz.codegenerator.entity.ColumnEntity;
import com.xz.codegenerator.entity.TableEntity;
import freemarker.template.Template;
import org.springframework.util.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：代码生成器
 * Created by Wuhy on 2017/5/1.
 */
public class CodeGenerateUtils {

    private final String AUTHOR = "Wuhy";
    private final String CURRENT_DATE = "2018/05/14";
    private final String tableName = "menu";
    private final String packageName = "com.yinhai.test";
    private final String tableAnnotation = "质量问题";
    private final String diskPath = "F:\\wuhy\\javacode\\com\\yinhai\\test\\";
    private final String changeTableName = replaceUnderLineAndUpperCase(tableName);
    private static Connection connection;
    public Connection getConnection() throws Exception{
        Class.forName(ConfigUtil.getSysConfig("jdbc.driverClassName"));
        Connection connection= DriverManager.getConnection(ConfigUtil.getSysConfig("jdbc.url"),
                ConfigUtil.getSysConfig("jdbc.username"),
                ConfigUtil.getSysConfig("jdbc.password"));
        return connection;
    }

    public static void main(String[] args) throws Exception{
        ConfigUtil.init();
        XmlUtil.init();
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        codeGenerateUtils.generate();

    }

    public void generate() throws Exception{
        try {
            if(connection==null){
                connection = getConnection();
            }
           List<TableEntity> tables = XmlUtil.tables;

            for(int i=0,size=tables.size();i<size;i++){
                TableEntity tableEntity=tables.get(i);
                //获取表信息
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableEntity.getName(),"%");
                //生成Mapper文件
                //生成java类
                ClassEntity classEntity=tableEntity.getClassEntity();
                generateServiceInterfaceFile(tableEntity,classEntity);
                generateControllerFile(tableEntity,classEntity);
                generateServiceImplFile(tableEntity,classEntity);
                generateMapperXmlFile(  tableEntity,  classEntity,resultSet);
                generateMapperFile(  tableEntity,  classEntity);
                resultSet = databaseMetaData.getColumns(null,"%", tableEntity.getName(),"%");
                generateEntityFile(  tableEntity,  classEntity,resultSet);

            }













           /* generateMapperXmlFile(resultSet);
            //生成服务层接口文件
            generateServiceInterfaceFile(resultSet);
            //生成服务实现层文件
            generateServiceImplFile(resultSet);
            //生成Controller层文件
            generateControllerFile(resultSet);
            //生成DTO文件
            generateDTOFile(resultSet);
            //生成Model文件
             generateModelFile(resultSet);*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{

        }
    }
    public String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    private void generateServiceInterfaceFile(TableEntity tableEntity,ClassEntity classEntity) throws Exception{
        final String suffix = "Service.java";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\service\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\service\\";
        }

        final String path = diskPath + upperCase(tableEntity.getName()) + suffix;
        final String templateName = "class\\ServiceInterface.ftl";
        File interFaseServiceFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        generateFileByTemplate(templateName,interFaseServiceFile,dataMap);
    }

    private void generateControllerFile(TableEntity tableEntity,ClassEntity classEntity) throws Exception{
        final String suffix = "Controller.java";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\controller\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\controller\\";
        }
        final String path = diskPath + upperCase(tableEntity.getName()) + suffix;
        final String templateName = "class\\Controller1.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        dataMap.put("jsp_file_path",tableEntity.getJspEntity().getJspFilePath());
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }


    private void generateServiceImplFile(TableEntity tableEntity,ClassEntity classEntity) throws Exception{
        final String suffix = "ServiceImpl.java";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\service\\impl\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\service\\impl\\";
        }

        final String path = diskPath + upperCase(tableEntity.getName()) + suffix;
        final String templateName = "class\\ServiceImpl.ftl";
        File interFaseServiceFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        generateFileByTemplate(templateName,interFaseServiceFile,dataMap);
    }

    private void generateMapperXmlFile(TableEntity tableEntity, ClassEntity classEntity,ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.xml";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\mapper\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\mapper\\";
        }
        final String templateName = "sql\\MapperXml.ftl";
        final String path = diskPath + tableEntity.getName() + suffix;
        File mapperFile = new File(path);
        List<ColumnEntity> ColumnEntityList = new ArrayList<>();
        ColumnEntity ColumnEntity = null;
        while(resultSet.next()){
            //id字段略过
            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            ColumnEntity = new ColumnEntity();
            //获取字段名称
            ColumnEntity.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            ColumnEntity.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            ColumnEntity.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            ColumnEntity.setColumnComment(resultSet.getString("REMARKS"));
            ColumnEntityList.add(ColumnEntity);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",ColumnEntityList);
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }
    private void generateMapperFile(TableEntity tableEntity,ClassEntity classEntity) throws Exception{
        final String suffix = "Mapper.java";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\domain\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\domain\\";
        }
        final String templateName = "class\\Mapper.ftl";
        final String path = diskPath + upperCase(tableEntity.getName()) + suffix;
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

















    private void generateEntityFile(TableEntity tableEntity,ClassEntity classEntity,ResultSet resultSet) throws Exception{

        final String suffix = "Entity.java";
        String diskPath="";
        String tablePackage=tableEntity.getPackageName();
        if(tablePackage==null||tablePackage==""){
            diskPath+=XmlUtil.filePath+XmlUtil.commonPackage.replaceAll(".","\\")+"\\entity\\";
        }else{
            diskPath+=XmlUtil.filePath+tableEntity.getPackageName().replaceAll("\\.","\\\\")+"\\entity\\";
        }
        final String templateName = "class\\Entity.ftl";
        final String path = diskPath + upperCase(tableEntity.getName()) + suffix;
        File entityFile = new File(path);
        List<ColumnEntity> ColumnEntityList = new ArrayList<>();
        ColumnEntity ColumnEntity = null;
        while(resultSet.next()){
            //id字段略过
            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            ColumnEntity = new ColumnEntity();
            //获取字段名称
            ColumnEntity.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            ColumnEntity.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            ColumnEntity.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            ColumnEntity.setColumnComment(resultSet.getString("REMARKS"));
            ColumnEntityList.add(ColumnEntity);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",ColumnEntityList);
        dataMap.put("table_name_small",tableEntity.getName());
        dataMap.put("table_name",upperCase(tableEntity.getName()));
        dataMap.put("table_annotation",upperCase(tableEntity.getTableAnnotation()));
        dataMap.put("package_name",(tablePackage==null||tablePackage=="")?XmlUtil.commonPackage:tablePackage);
        generateFileByTemplate(templateName,entityFile,dataMap);

    }





    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        if(!file.exists()){
            File path=new File(file.getParent());
            if(!path.isDirectory()){
                path.mkdirs();
            }
        }
         FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }

    public String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

}

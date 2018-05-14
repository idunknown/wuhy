package com.xz.codegenerator.util;

import com.xz.codegenerator.entity.ClassEntity;
import com.xz.codegenerator.entity.JspEntity;
import com.xz.codegenerator.entity.SqlEntity;
import com.xz.codegenerator.entity.TableEntity;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wuhy on 2018/5/14.
 */
public class XmlUtil {

    public static String  commonPackage;
    public static String  filePath;
    public static List tables=new ArrayList();

    public static void init() throws Exception{
        XmlUtil.readXML();
    }
    public static void readXML() throws Exception {
        // 创建saxReader对象
        SAXReader reader;
        reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(ConfigUtil.class.getResourceAsStream("../../../../xmlconfig/generatorConfig.xml"));
        //获取根节点元素对象
        Element node = document.getRootElement();
        //遍历所有的元素节点
        parseNode(node);
    }
    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *
     * @param node
     */
    public static void parseNode(Element node) {
        Element commonNode=node.element("common");
        Element tablesNode=node.element("tables");
        if("common".equals(commonNode.getName())){
            List<Attribute> list = commonNode.attributes();
            // 遍历属性节点
            XmlUtil.commonPackage=commonNode.element("package").getText().trim();
            XmlUtil.filePath=commonNode.element("file-path").getText().trim();

        }

        /*遍历tables下的表并根据相应内容创建对象*/
        Iterator<Element> it = tablesNode.elementIterator();
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            if("table".equals(e.getName())){
                TableEntity tableEntity=new TableEntity();
                tableEntity.setName(e.attributeValue("name"));
                tableEntity.setPackageName(e.attributeValue("package-name"));
                tableEntity.setTableAnnotation(e.attributeValue("table-annotation"));

                Element javaClass=e.element("class");
                Element sql=e.element("sql");
                Element jsp=e.element("jsp");

                ClassEntity classEntity=new ClassEntity();
                classEntity.setIncludeClass(javaClass.attributeValue("include-class"));
                classEntity.setNoIncludeClass(javaClass.attributeValue("no-include-class"));
                classEntity.setTemplatesPath(javaClass.attributeValue("templates-path"));
                tableEntity.setClassEntity(classEntity);


                SqlEntity sqlEntity=new SqlEntity();
                sqlEntity.setTemplatesPath(sql.attributeValue("templates-path"));

                JspEntity jspEntity = new JspEntity();
                jspEntity.setTemplatesPath(jsp.attributeValue("templates-path"));
                jspEntity.setJspFilePath(jsp.attributeValue("jsp-file-path"));
                tableEntity.setSqlEntity(sqlEntity);
                tableEntity.setJspEntity(jspEntity);
                XmlUtil.tables.add(tableEntity);
            }
        }

        /*// 获取当前节点的所有属性节点

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e);
        }*/
    }

}

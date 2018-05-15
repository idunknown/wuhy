package com.yinhai.test.he.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
* 描述：描述描述模型
* @author Wuhy
* @date 2018/05/14
*/

public class MenuEntity {

        private Map map = new HashMap();
        /**菜单id**/
        private int menuid;
        /**名称**/
        private String name;
        /**访问路径**/
        private String url;
        /**有效标志**/
        private String effective;

        public int getMenuid() {
            return this.menuid;
        }
        public void setMenuid(int menuid) {
           this.menuid = menuid;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
           this.name = name;
        }
        public String getUrl() {
            return this.url;
        }
        public void setUrl(String url) {
           this.url = url;
        }
        public String getEffective() {
            return this.effective;
        }
        public void setEffective(String effective) {
           this.effective = effective;
        }

        public Map toMap(){

            this.map.put("menuid",this.menuid);
            this.map.put("name",this.name);
            this.map.put("url",this.url);
            this.map.put("effective",this.effective);
            return this.map;
       }
        public MenuEntity(Map map){
             this.menuid = (int)map.get("menuid");
            this.name = (String)map.get("name");
            this.url = (String)map.get("url");
            this.effective = (String)map.get("effective");
       }
}
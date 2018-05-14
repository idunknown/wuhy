package com.xz.codegenerator.util;


import org.springframework.util.ObjectUtils;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author  wuhy on 2017/11/9.
 */
public class ConfigUtil {

        private static Map configMap = null;
        private static String fileEncoding = "utf-8" ;
                public static void init(){
                   InputStream in=  null;
                   Properties p=null;
                   try {
                      //  Object.class.getResourceAsStream("config/jdbc.properties");
                       System.getProperty("user.dir");
                       in =  ConfigUtil.class.getResourceAsStream("../../../../config/jdbc.properties");
                       p = new Properties();
                       p.load(in);
                       configMap=new HashMap(p);
                   }catch (Exception e){
                       e.printStackTrace();
                   }


    }
  /*  private static void initSysconfig() {
        configMap = new HashMap();
        Properties props = new Properties();
        BufferedReader bf = null;
        try {
            ClassPathResource classPathResource= new ClassPathResource("config/config.properties");
            bf = new BufferedReader(new InputStreamReader(classPathResource.getInputStream(), fileEncoding));
            props.load(bf);
            Iterator it_bs1 = props.entrySet().iterator();

            while(it_bs1.hasNext()) {
                Map.Entry m = (Map.Entry)it_bs1.next();
                configMap.put(m.getKey(), m.getValue());
            }
        } catch (Exception var20) {
            var20.printStackTrace();
        } finally {
            if(bf != null) {
                try {
                    bf.close();
                } catch (IOException var18) {
                    var18.printStackTrace();
                }
            }

        }

    }*/

    public static Map getConfigs() {
        return configMap == null?null:configMap;
    }

    public static String getSysConfig(String key) {
        return configMap == null?null:(String)configMap.get(key);
    }

    public static Integer getSysConfigToInteger(String key) {
        String value = getSysConfig(key);
        Integer configValue = null;

        try {
            configValue = Integer.valueOf(value);
        } catch (NumberFormatException var4) {
            configValue = null;
        }

        return configValue;
    }

    public static Integer getSysConfigToInteger(String key, int defaultValue) {
        Integer value = getSysConfigToInteger(key);
        return value == null?Integer.valueOf(defaultValue):value;
    }

    public static boolean getSysconfigToBoolean(String key) {
        String bool = getSysConfig(key);
        return bool != null && (Boolean.parseBoolean(bool) || "true".equals(bool));
    }

    public static boolean getSysconfigToBoolean(String key, boolean defaultValue) {
        String bool = getSysConfig(key);
        return bool != null && !"".equals(bool)?Boolean.parseBoolean(bool) || "true".equals(bool):defaultValue;
    }

    public static String getSysConfig(String key, boolean isSuperposition, String... args) {
        String tmp = getSysConfig(key);
        if(!isSuperposition) {
            return MessageFormat.format(tmp, args);
        } else {
            tmp = tmp == null?"":tmp;
            String[] var7 = args;
            int var6 = args.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                String arg = var7[var5];
                tmp = tmp + arg;
            }

            return tmp;
        }
    }

    public static String getSysConfig(String key, String defaultValue) {
        String configvalue = getSysConfig(key);

        return ObjectUtils.isEmpty(configvalue)?defaultValue:configvalue;
    }

    public static String getSysConfig(String key, String defaultValue, boolean isSuperposition, String... args) {
        String tmp = getSysConfig(key, defaultValue);
        if(!isSuperposition) {
            return MessageFormat.format(tmp, args);
        } else {
            tmp = tmp == null?"":tmp;
            String[] var8 = args;
            int var7 = args.length;

            for(int var6 = 0; var6 < var7; ++var6) {
                String arg = var8[var6];
                tmp = tmp + arg;
            }

            return tmp;
        }
    }



}

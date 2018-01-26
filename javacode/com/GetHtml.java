package com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuhy on 2017/8/4.
 */
public class GetHtml {
    public  static void main(String[] a){
        try {
            URL url = new URL("http://www.cddrc.gov.cn/zhuanti/more.action?classId=02071403&page=1");
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            String out="";
            while ((str = bufr.readLine()) != null) {
                out+=str;
               // System.out.println(str);
            }
            bufr.close();
            isr.close();
            in.close();
        //    System.out.print(out.indexOf("<div class=\"cnt\">"));
            String[] aa= out.split("<div class=\"cnt\">");
            out=aa[1];
            aa=out.split("</ul>");
            out=aa[0];
           out= out.replaceAll("href","data-url");
           // System.out.println(out+"</ul>");

            String page=aa[1];
            String bb="共 2 页，每页 25 条记录，共 26 条记录";
            String re="共(.*?)条记录";
            String total=getMatcher(re,page);
            System.out.print(total.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void main2(String[] a){
        try {
            URL url = new URL("http://www.cddrc.gov.cn/zhuanti/detail.action?id=851594&classId=02071403");
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            String out="";
            while ((str = bufr.readLine()) != null) {
                out+=str;
                // System.out.println(str);
            }
            bufr.close();
            isr.close();
            in.close();
            if(!out.contains("more-center")){
                System.out.print(url);

            }else{
                System.out.print(out);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void main3(String[] a){
        try {
            URL url = new URL("http://www.cddrc.gov.cn/zhuanti/detail.action?id=850836&classId=02071403");
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            String out="";
            while ((str = bufr.readLine()) != null) {
                out+=str;
                // System.out.println(str);
            }
            bufr.close();
            isr.close();
            in.close();

            String re="<div class=\"more-center\">(.*?)<div style=\"width:100%; clear:both;height:0px;\"></div>";
            getMatcher(re,out);
            System.out.print( "<div class=\"more-center\">"+getMatcher(re,out));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getMatcher(String regex, String source) {
              String result = "";
               Pattern pattern = Pattern.compile(regex);
              Matcher matcher = pattern.matcher(source);
                while (matcher.find()) {
                        result = matcher.group(1);
               }
               return result;
            }

}

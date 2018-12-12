package com.utunan.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 王碧云
 * @description: 一些关于院校库和详情页会用到的方法
 * @date 2018/12/6/006 17:40
 */
public class SchoolOther {

    /*
     * @author  王碧云
     * @description 将字符数组转为字符串
     * @date  8:34 2018/12/5/005
     * @param  [list]
     * @return  java.lang.String
     */
    public String listToString(String[] list){
        if (list == null){
            return null;
        }else {
            String s =String.join(",",list);
            return s;
        }
    }

    /*
     * @author  王碧云
     * @description 判断返回的参数是否选中全部
     * @date  21:33 2018/11/29/029
     * @param  [list]
     * @return  java.lang.String[]
     */
    public String[] clickAll(String[] list){
        if(list==null){
            return list;
        }else {
            for(String l:list){
                if(l.equals("全部")){
                    list=null;
                    break;
                }
            }
            return list;
        }
    }
    /*
     * @author  王碧云
     * @description 判断搜索条件是否为空
     * @date  20:37 2018/12/7/007
     * @param  [list]
     * @return  java.lang.String
     */
    public String[] ifListIsNull(String[] list){
        if(list==null || list.length==0){
            list= new String[]{"全部"};
        }
        return list;
    }

    /*
     * @author  王碧云
     * @description 设置招生简章的年份，如果当前月份大于9月，则年份为当前年份，如果月份小于9月，则年份-1
     * @date  15:18 2018/12/12/012
     * @param  []
     * @return  java.lang.String
     */
    public String theYear(){
        //确定当前的年份和月份
        SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfmonth = new SimpleDateFormat("MM");
        Date date = new Date();
        String year = sdfyear.format(date);
        String month = sdfmonth.format(date);
        //如果月份大于九月，显示今年的招生简章，如果小于九月，显示去年的招生简章
        if(Integer.parseInt(month)<9){
            year = String.valueOf(Integer.parseInt(year)-1);
        }
        return year;
    }
}

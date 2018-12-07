package com.utunan.util;

import java.util.Arrays;

/**
 * @author 王碧云
 * @description: 一些关于院校库会用到的方法
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

}

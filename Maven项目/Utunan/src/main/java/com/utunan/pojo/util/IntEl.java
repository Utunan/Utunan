package com.utunan.pojo.util;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/4/004 14:58
 */
public class IntEl {

    public static boolean judgeInclude(List<Long> list,int num) {
        for(Long l:list){
            if(l==num){
                return true;
            }
        }
        return false;
    }


}

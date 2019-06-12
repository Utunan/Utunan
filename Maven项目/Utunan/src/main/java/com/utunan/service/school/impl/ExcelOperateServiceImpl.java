package com.utunan.service.school.impl;

import com.utunan.util.ExcelOperate;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service("excelOperateService")
public class ExcelOperateServiceImpl {

    ExcelOperate excelOperate=new ExcelOperate();
    public String[][] getData(File file, int ignoreRows){

        try {
            return excelOperate.getData(file,ignoreRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0][];
    }

}

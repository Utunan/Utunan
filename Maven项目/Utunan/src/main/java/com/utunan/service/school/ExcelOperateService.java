package com.utunan.service.school;

import java.io.File;

public interface ExcelOperateService {

    String[][] getData(File file, int ignoreRows);
}

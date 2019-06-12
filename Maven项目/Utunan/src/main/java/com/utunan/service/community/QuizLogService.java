package com.utunan.service.community;

import com.utunan.pojo.util.QuizLog;
import com.utunan.service.community.QuizLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 唐溪
 * @description: TODO
 * @date 2019/5/28 11:38
 */
public interface QuizLogService {

    void printLog(Long quizId, Long userId);
}

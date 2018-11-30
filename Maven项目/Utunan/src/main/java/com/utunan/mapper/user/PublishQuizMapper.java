package com.utunan.mapper.user;

import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishQuiz;

import java.util.List;

public interface PublishQuizMapper {

    List<PublishQuiz> selecAllQuizCollectorByUser(User user);

}

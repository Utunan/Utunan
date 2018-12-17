package com.utunan.pojo.inherit.user;

import com.utunan.pojo.base.user.DirectionCollector;
import com.utunan.pojo.base.user.User;

import java.util.List;

public class Member extends User {

    private List<User> followUsers;
    private List<PublishQuiz> publishQuizs;
    private List<DirectionCollector> directionCollectors;

}

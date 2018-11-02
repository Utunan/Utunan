package com.utunan.mapper;

import com.utunan.pojo.Girl;

public interface GirlMapper {
    int insert(Girl girl);
    Girl queryById(long id);
    Girl queryByName(String name);
}

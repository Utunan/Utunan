package com.utunan.mapper.user;

import com.utunan.pojo.school.Direction;
import com.utunan.pojo.user.SchoolCollector;
import com.utunan.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface SchoolCollectorMapper {
    List<Direction> selectSchoolCollector(User user);
}

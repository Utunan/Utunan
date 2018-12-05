package com.utunan.mapper.user;

import com.utunan.pojo.inherit.user.PublishDirectionCollector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/3/003 9:53
 */
@Mapper
@Repository
public interface PublishDirectionCollectorMapper {

     /*王碧云 根据用户查找收藏的院校*/
    List<PublishDirectionCollector> findDirectionCollectorByUser(@Param("userId") Long userId);
    /*王碧云 根据用户查找收藏的院校Id*/
    List<Long> findDirectionIdByUser(@Param("userId") Long userId);
//    王碧云 加入院校收藏夹
    void insertDirectionCollector(@Param("userId") Long userId,@Param("directionId") Long directionId);
}

package com.utunan.service.user;

import com.utunan.pojo.inherit.user.PublishDirectionCollector;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/3/003 10:02
 */
public interface PublishDirectionCollectorService {
    /*王碧云 根据用户查找收藏的院校*/
    List<PublishDirectionCollector> findDirectionCollectorByUser(Long userId);
    /*王碧云 根据用户查找收藏的院校Id*/
    List<Long> findDirectionIdByUser(Long userId);
    /*王碧云 加入院校收藏夹*/
    void insertDirectionCollector(Long userId,Long directionId);
    /*王碧云 在院校收藏夹中删除*/
    void deleteDirectionCollector(Long userId,Long directionId);
    /*判断某用户是否收藏某院校*/
    PublishDirectionCollector findDCollector(Long directionId,Long userId);
}

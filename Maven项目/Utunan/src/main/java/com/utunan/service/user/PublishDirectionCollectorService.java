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

    List<Long> findDirectionIdByUser(Long userId);
}

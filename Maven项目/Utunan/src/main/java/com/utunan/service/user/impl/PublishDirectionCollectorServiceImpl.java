package com.utunan.service.user.impl;

import com.utunan.mapper.user.PublishDirectionCollectorMapper;
import com.utunan.pojo.inherit.user.PublishDirectionCollector;
import com.utunan.service.school.PublishDirectionService;
import com.utunan.service.user.PublishDirectionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/3/003 10:04
 */
@Service("publishDirectionCollectorService")
public class PublishDirectionCollectorServiceImpl implements PublishDirectionCollectorService {

    @Autowired
    private PublishDirectionCollectorMapper publishDirectionCollectorMapper;
    /*
     * @author  王碧云
     * @description 查找用户收藏的院校
     * @date  10:08 2018/12/3/003
     * @param  [userId]
     * @return  java.util.List<com.utunan.pojo.inherit.user.PublishDirectionCollector>
     */
    @Override
    public List<PublishDirectionCollector> findDirectionCollectorByUser(Long userId) {
        return this.publishDirectionCollectorMapper.findDirectionCollectorByUser(userId);
    }
    /*
     * @author  王碧云
     * @description 查找用户收藏的院校Id
     * @date  19:58 2018/12/4/004
     * @param  [userId]
     * @return  java.util.List<java.lang.Long>
     */
    @Override
    public List<Long> findDirectionIdByUser(Long userId) {
        return this.publishDirectionCollectorMapper.findDirectionIdByUser(userId);
    }
    /*
     * @author  王碧云
     * @description 加入用户院校收藏夹
     * @date  19:58 2018/12/4/004
     * @param  [userId, directionId]
     * @return  void
     */
    @Override
    public void insertDirectionCollector(Long userId, Long directionId) {
        this.publishDirectionCollectorMapper.insertDirectionCollector(userId,directionId);
    }
}

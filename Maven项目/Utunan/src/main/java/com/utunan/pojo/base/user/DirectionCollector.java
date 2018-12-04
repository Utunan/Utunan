package com.utunan.pojo.base.user;

/**
 * @author 王碧云
 * @description: 院校信息收藏
 * @date 2018/12/3/003 9:20
 */
public class DirectionCollector {
    //院校信息收藏列表
    private Long directionCollectorId;
    //用户Id
    private Long userId;
    //研究方向Id
    private Long directionId;

    public Long getDirectionCollectorId() {
        return directionCollectorId;
    }

    public void setDirectionCollectorId(Long directionCollectorId) {
        this.directionCollectorId = directionCollectorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    @Override
    public String toString() {
        return "DirectionCollector{" +
                "directionCollectorId=" + directionCollectorId +
                ", userId=" + userId +
                ", directionId=" + directionId +
                '}';
    }

}

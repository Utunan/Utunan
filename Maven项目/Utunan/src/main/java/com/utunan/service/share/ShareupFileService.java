package com.utunan.service.share;

public interface ShareupFileService {
    //查询对应标签ID
    Long getSuffix(String filetype);

    void insertfile(String sourcetype, String title, String school, Long userId, String path, Long suffixId, Long integral);
}

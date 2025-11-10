package cn.keking.newPro.service;

import cn.keking.newPro.components.cache.annotation.BizCacheable;
import cn.keking.newPro.entity.FileInfo;
import cn.keking.newPro.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileInfoService {

    @Autowired
    FileInfoMapper fileMapper;


    @BizCacheable(
            value = "fileInfoCache", // 缓存的名称（对应配置的 CacheManager 中的缓存区域）
            key = "#fileId",         // 缓存键，使用方法的参数 fileId
            desc = "根据ID查询文件信息"
            // timeToLiveSeconds = 3600 // 如果您封装的注解支持过期时间
    )
    public FileInfo getFileInfoById(Integer fileId) {
        return fileMapper.findFileInfoById(fileId);
    }

}

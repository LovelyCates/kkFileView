package cn.keking.newPro.service;

import cn.keking.newPro.entity.FileInfo;
import cn.keking.newPro.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileInfoService {

    @Autowired
    FileInfoMapper fileMapper;

    public FileInfo getFileInfoById(Integer fileId) {
        return fileMapper.findFileInfoById(fileId);
    }

}

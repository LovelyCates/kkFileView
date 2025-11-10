package cn.keking.newPro.mapper;

import cn.keking.newPro.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileInfoMapper {

    FileInfo findFileInfoById(
            @Param("fileId") Integer fileId
    );

}

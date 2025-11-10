package cn.keking.newPro.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileInfo {

    private String fileId;

    private String fileNam;

    private String fileMd5;

    private String fileTyp;

}
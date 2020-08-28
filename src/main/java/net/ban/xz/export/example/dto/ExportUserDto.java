package net.ban.xz.export.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ban.xz.export.example.pojo.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExportUserDto {

    private Integer serial;
    private String userName;
    private String realName;
    private String phone;
    private String email;
    private String locked;
    private String deleted;
    private String createTime;
    private String updateTime;

    public static ExportUserDto from(User source){
       return ExportUserDto.builder()
               .userName(source.getUserName())
               .realName(source.getRealName())
               .phone(source.getPhone())
               .email(source.getEmail())
               .locked(source.getLocked() == false ? "正常":"锁定")
               .deleted(source.getDeleted() == false ? "正常":"已删除")
               .createTime(convert(source.getCreateTime()))
               .updateTime(convert(source.getUpdateTime()))
               .build();
    }

    public static String convert(LocalDateTime source) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(source);
    }

}

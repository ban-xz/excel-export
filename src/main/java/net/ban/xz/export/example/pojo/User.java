package net.ban.xz.export.example.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String userName;

    private String realName;

    private String phone;

    private String email;

    private Boolean locked;

    private Boolean deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

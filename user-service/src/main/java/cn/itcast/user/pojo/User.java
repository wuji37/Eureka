package cn.itcast.user.pojo;

import lombok.Data;

@Data //注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
public class User {
    private Long id;
    private String username;
    private String address;
}

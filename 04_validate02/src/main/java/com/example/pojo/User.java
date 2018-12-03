package com.example.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Description:
 *  常用注解总结
 *   @NotBlank: 判断字符串是否为 null 或者是空串(去掉首尾空格)。
 *   @NotEmpty: 判断字符串是否 null 或者是空串。
 *   @Length: 判断字符的长度(最大或者最小)
 *   @Min: 判断数值最小值
 *   @Max: 判断数值最大值
 *   @Email: 判断邮箱是否合法
 * @Auther: zhangfx
 * @Date: 2018/12/3/ 14:56
 */
public class User {

    @NotBlank(message = "用户名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Min(value = 18,message = "年龄不能小于18")
    @Max(value = 60,message = "年龄不能大于60")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

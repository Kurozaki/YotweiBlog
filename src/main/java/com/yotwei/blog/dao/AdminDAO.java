package com.yotwei.blog.dao;

import com.yotwei.blog.enity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by YotWei on 2018/3/12.
 */
public interface AdminDAO {
    Admin loginQuery(@Param("account") String account, @Param("pwd") String passwordMD5);
}

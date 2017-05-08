package com.xaaolaf.doman.repository;

import com.xaaolaf.doman.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by xupingwei on 2017/5/7.
 * 上面的方法findByNameAndPassword，spring-data-jpa规定，方法都以findBy开头，
 * sql的where部分就是NameAndPassword，被spring-data-jpa翻译之后就编程了下面这种形态：
 * <p>
 * where name = ? and password = ?
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

//    @Query("from UserInfo user where user.phone =?1")
//    boolean phoneEmpty(String phone);

    //    @Query("from UserInfo user where user.phone ==?1")
    UserInfo findByPhone(String phone);
}

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 10:24
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void sayHi(){
        System.out.println("hello , Repository");
    }
}

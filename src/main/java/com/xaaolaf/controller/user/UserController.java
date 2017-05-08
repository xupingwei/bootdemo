package com.xaaolaf.controller.user;

import com.xaaolaf.controller.ResultBean;
import com.xaaolaf.controller.ResultCode;
import com.xaaolaf.doman.bean.Address;
import com.xaaolaf.doman.bean.UserInfo;
import com.xaaolaf.doman.repository.UserRepository;
import com.xaaolaf.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xupingwei on 2017/5/3.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/find_user", method = RequestMethod.POST)
    public ResultBean findUser(@RequestParam(value = "phone") String phone) {
        //返回数组
        ResultBean<UserInfo> result = new ResultBean<>();
        UserInfo userInfo = findUserByPhone(phone);
        result.setCode(ResultCode.OK);
        result.setResult(userInfo);
        return result;
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ResultBean addUser(@RequestParam(value = "phone") String phone,
                              @RequestParam(value = "password") String password) {

        //返回数组
        ResultBean<UserInfo> result = new ResultBean<>();
        Map<String, String> map = new HashMap();
        UserInfo user = userRepository.findByPhone(phone);
        if (null != user) {
            result.setCode(ResultCode.Failed);
            result.setMsg("用户名已经存在");
            UserInfo u = new UserInfo();
            u.setPhone(phone);
            result.setResult(u);
            return result;
        }

        UserInfo userInfo = new UserInfo(phone, password);
        userInfo.setAddress(new Address("beijing", "Road 18"));
        map.put("phone", phone);
        map.put("password", password);
        userInfo.setToken(TokenManager.createSign(map, true));
        save(userInfo);
        result.setCode(ResultCode.OK);
        result.setMsg("用户创建成功");
        result.setResult(userInfo);
        return result;
    }


    @RequestMapping(value = "/login")
    public ResultBean login(@RequestParam(value = "phone") String phone,
                            @RequestParam(value = "password") String password) {

        //返回数组
        ResultBean resultBean = new ResultBean<>();
        boolean exit = phoneEmpty(phone);
        if (exit) {
            resultBean.setCode(ResultCode.Failed);
            resultBean.setMsg("用户名不存在");
            return resultBean;
        }
        resultBean = loginProcess(phone, password);
        return resultBean;
    }


    /**
     * 保存
     *
     * @param userInfo
     */

    public void save(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    /**
     * @param phone
     * @return
     */
    public boolean phoneEmpty(String phone) {
        return userRepository.findByPhone(phone) == null;
    }

    public ResultBean loginProcess(String phone, String password) {

        UserInfo userInfo = userRepository.findByPhone(phone);
        String pass = userInfo.getPassword();
        //返回bean
        ResultBean<UserInfo> resultBean = new ResultBean<>();
        if (password.equals(pass)) {
            resultBean.setCode(ResultCode.OK);
            resultBean.setResult(userInfo);
            resultBean.setMsg("登录成功");
            return resultBean;
        }
        resultBean.setCode(ResultCode.Failed);
        resultBean.setMsg("密码不正确");
        //把错误信息返回
        UserInfo u = new UserInfo(phone, password);
        resultBean.setResult(u);
        return resultBean;
    }

    public UserInfo findUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

}

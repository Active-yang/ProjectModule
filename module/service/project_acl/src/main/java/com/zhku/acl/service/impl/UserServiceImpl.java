package com.zhku.acl.service.impl;

import com.zhku.acl.entity.User;
import com.zhku.acl.mapper.UserMapper;
import com.zhku.acl.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WZX
 * @since 2022-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

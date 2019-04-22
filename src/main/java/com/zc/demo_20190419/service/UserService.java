package com.zc.demo_20190419.service;

import com.github.pagehelper.PageHelper;
import com.zc.demo_20190419.domain.entity.SysUser;
import com.zc.demo_20190419.domain.entity.SysUserExample;
import com.zc.demo_20190419.domain.repository.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private SysUserMapper userMapper;



    //分页查询用户列表数据
    public Map<String,Object> userList(int pageIndex,int pageSize,String searchKey){
        SysUserExample sysUserExample=new SysUserExample();
        SysUserExample.Criteria criteria=sysUserExample.createCriteria();
        //条件非空判断
        if (!StringUtils.isEmpty(searchKey)){
            criteria.andUsernameLike(searchKey);
        }
        //开启分页
        PageHelper.startPage(pageIndex,pageSize);
        List<SysUser> users=userMapper.selectByExample(sysUserExample);
        int count =(int)userMapper.countByExample(sysUserExample);
        Map<String ,Object> userData=new HashMap<>();
        userData.put("users",users);
        userData.put("count",count);
        return userData;

    }

    //删除用户
    public boolean delUser(String id){
        SysUserExample userExample=new SysUserExample();
        SysUserExample.Criteria criteria=userExample.createCriteria();
        if (StringUtils.isEmpty(id)){
            id="-1";
        }
        criteria.andIdEqualTo(Long.valueOf(id));

        int res=userMapper.deleteByExample(userExample);
        return res==1;
    }

    //修改用户
    public boolean updateUser(SysUser user){
        return false;
    }

    //添加用户
    public boolean saveUser(SysUser user){
        SysUserExample sysUserExample=new SysUserExample();
        int res=userMapper.insert(user);
        return res==1;
    }
}

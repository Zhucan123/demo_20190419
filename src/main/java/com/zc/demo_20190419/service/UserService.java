package com.zc.demo_20190419.service;

import com.github.pagehelper.PageHelper;
import com.zc.demo_20190419.domain.entity.SysUser;
import com.zc.demo_20190419.domain.entity.SysUserExample;
import com.zc.demo_20190419.domain.repository.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

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
        //计算年龄
        Calendar fromDate=Calendar.getInstance();
        fromDate.setTime(user.getBirthday());
        Calendar toDate=Calendar.getInstance();
        toDate.setTime(new Date());
        user.setAge(toDate.get(Calendar.YEAR)-fromDate.get(Calendar.YEAR));

        //计算年龄2
        //user.setAge((int)((new Date().getTime()-user.getBirthday().getTime())/(1000 * 60 * 60 * 12*365)));
        int res=0;
        if (user.getId()!=null){
            //有id的就进行更新
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(user.getId());

            res=userMapper.updateByExample(user,example);
        }else{
            //无id就是新增操作
           res =userMapper.insert(user);
        }

        return res==1;
    }


    //检查登录名是否重复
    public boolean checkLoginName(String loginName,String id){
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        criteria.andLoginnameEqualTo(loginName);
        //先看名字是否重复
        boolean name=userMapper.countByExample(example)>0;
        //如果名字重复但是id也一样的视为修改
        if (name){
            criteria.andIdEqualTo(Long.valueOf(id));
            return userMapper.countByExample(example)==0;
        }
        return false;

    }

    //通过id查询单个用户
    public SysUser findOne(String id){
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria= example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(id));

        List<SysUser> users=userMapper.selectByExample(example);
        if (!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}

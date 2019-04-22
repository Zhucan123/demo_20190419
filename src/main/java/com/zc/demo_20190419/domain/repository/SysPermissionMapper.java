package com.zc.demo_20190419.domain.repository;

import com.zc.demo_20190419.domain.entity.SysPermission;
import com.zc.demo_20190419.domain.entity.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    long countByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    int deleteByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    @Insert({
        "insert into sys_permission (id, name, ",
        "description, url, ",
        "pid)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=BIGINT})"
    })
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    List<SysPermission> selectByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated Mon Apr 22 15:07:14 CST 2019
     */
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);
}
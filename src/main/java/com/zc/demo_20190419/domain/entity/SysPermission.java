package com.zc.demo_20190419.domain.entity;

public class SysPermission extends BaseDomain {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.id
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.name
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.description
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.url
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.pid
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    private Long pid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.id
     *
     * @return the value of sys_permission.id
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.id
     *
     * @param id the value for sys_permission.id
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.name
     *
     * @return the value of sys_permission.name
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.name
     *
     * @param name the value for sys_permission.name
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.description
     *
     * @return the value of sys_permission.description
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.description
     *
     * @param description the value for sys_permission.description
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.url
     *
     * @return the value of sys_permission.url
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.url
     *
     * @param url the value for sys_permission.url
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.pid
     *
     * @return the value of sys_permission.pid
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.pid
     *
     * @param pid the value for sys_permission.pid
     *
     * @mbg.generated Tue Apr 23 10:49:16 CST 2019
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
}
package com.zoctan.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "enviroment_db")
public class EnviromentDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 连接名称
     */
    private String name;

    /**
     * mysql，oracle，redis
     */
    private String type;

    /**
     * 连接ip
     */
    private String ip;

    /**
     * 端口号
     */
    private String port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 连接库名
     */
    private String dbname;

    /**
     * 连接字
     */
    private String connectstr;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 上一次修改时间
     */
    @Column(name = "lastmodify_time")
    private Date lastmodifyTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 项目id
     */
    private Long envid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取连接名称
     *
     * @return name - 连接名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置连接名称
     *
     * @param name 连接名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取mysql，oracle，redis
     *
     * @return type - mysql，oracle，redis
     */
    public String getType() {
        return type;
    }

    /**
     * 设置mysql，oracle，redis
     *
     * @param type mysql，oracle，redis
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取连接ip
     *
     * @return ip - 连接ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置连接ip
     *
     * @param ip 连接ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取端口号
     *
     * @return port - 端口号
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置端口号
     *
     * @param port 端口号
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取连接库名
     *
     * @return dbname - 连接库名
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * 设置连接库名
     *
     * @param dbname 连接库名
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    /**
     * 获取连接字
     *
     * @return connectstr - 连接字
     */
    public String getConnectstr() {
        return connectstr;
    }

    /**
     * 设置连接字
     *
     * @param connectstr 连接字
     */
    public void setConnectstr(String connectstr) {
        this.connectstr = connectstr;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取上一次修改时间
     *
     * @return lastmodify_time - 上一次修改时间
     */
    public Date getLastmodifyTime() {
        return lastmodifyTime;
    }

    /**
     * 设置上一次修改时间
     *
     * @param lastmodifyTime 上一次修改时间
     */
    public void setLastmodifyTime(Date lastmodifyTime) {
        this.lastmodifyTime = lastmodifyTime;
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取项目id
     *
     * @return envid - 项目id
     */
    public Long getEnvid() {
        return envid;
    }

    /**
     * 设置项目id
     *
     * @param envid 项目id
     */
    public void setEnvid(Long envid) {
        this.envid = envid;
    }
}
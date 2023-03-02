package com.zoctan.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Deployunit {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    private Long projectid;

    public Long getApicounts() {
        return apicounts;
    }

    public void setApicounts(Long apicounts) {
        this.apicounts = apicounts;
    }

    private Long apicounts;

    /**
     * 微服务名
     */
    private String deployunitname;

    /**
     * 协议
     */
    private String protocal;

    /**
     * 访问端口
     */
    private String port;

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    private String baseurl;




    /**
     * 描述
     */
    private String memo;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    private String creator;

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
     * 访问ip
     */
    private String ip;

    /**
     * 环境id
     */
    private long envid;

    /**
     * 获取Id
     *
     * @return id - Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置Id
     *
     * @param id Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取微服务名
     *
     * @return deployunitname - 微服务名
     */
    public String getDeployunitname() {
        return deployunitname;
    }

    /**
     * 设置微服务名
     *
     * @param deployunitname 微服务名
     */
    public void setDeployunitname(String deployunitname) {
        this.deployunitname = deployunitname;
    }

    /**
     * 获取协议
     *
     * @return protocal - 协议
     */
    public String getProtocal() {
        return protocal;
    }

    /**
     * 设置协议
     *
     * @param protocal 协议
     */
    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    /**
     * 获取访问端口
     *
     * @return port - 访问端口
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置访问端口
     *
     * @param port 访问端口
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取描述
     *
     * @return memo - 描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置描述
     *
     * @param memo 描述
     */
    public void setMemo(String memo) {
        this.memo = memo;
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
     * 获取Ip
     *
     * @return ip - ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置Ip
     *
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getEnvid() {
        return envid;
    }

    public void setEnvid(Long envid) {
        this.envid = envid;
    }
}
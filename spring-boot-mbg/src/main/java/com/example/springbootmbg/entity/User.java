package com.example.springbootmbg.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class User {
    /**
     * 用户id
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    @Column(name = "face_icon")
    private String faceIcon;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户粉丝数
     */
    @Column(name = "fans_counts")
    private Integer fansCounts;

    /**
     * 关注其他用户数
     */
    @Column(name = "follow_counts")
    private Integer followCounts;

    /**
     * 收到的喜欢数目
     */
    @Column(name = "receive_like_counts")
    private Integer receiveLikeCounts;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(String id) {
        this.id = id;
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
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户头像
     *
     * @return face_icon - 用户头像
     */
    public String getFaceIcon() {
        return faceIcon;
    }

    /**
     * 设置用户头像
     *
     * @param faceIcon 用户头像
     */
    public void setFaceIcon(String faceIcon) {
        this.faceIcon = faceIcon;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户粉丝数
     *
     * @return fans_counts - 用户粉丝数
     */
    public Integer getFansCounts() {
        return fansCounts;
    }

    /**
     * 设置用户粉丝数
     *
     * @param fansCounts 用户粉丝数
     */
    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * 获取关注其他用户数
     *
     * @return follow_counts - 关注其他用户数
     */
    public Integer getFollowCounts() {
        return followCounts;
    }

    /**
     * 设置关注其他用户数
     *
     * @param followCounts 关注其他用户数
     */
    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    /**
     * 获取收到的喜欢数目
     *
     * @return receive_like_counts - 收到的喜欢数目
     */
    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * 设置收到的喜欢数目
     *
     * @param receiveLikeCounts 收到的喜欢数目
     */
    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
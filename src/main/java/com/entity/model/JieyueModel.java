package com.entity.model;

import com.entity.JieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 借阅表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-25
 */
public class JieyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 借阅人 Search
     */
    private Integer yhTypes;


    /**
     * 借阅书名 Search
     */
    private Integer tsTypes;


    /**
     * 图书类别 Search
     */
    private Integer lbTypes;


    /**
     * 图书出版社 Search
     */
    private Integer cbsTypes;


    /**
     * 所在书架 Search
     */
    private Integer sjTypes;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：借阅人 Search
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：借阅人 Search
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：借阅书名 Search
	 */
    public Integer getTsTypes() {
        return tsTypes;
    }


    /**
	 * 获取：借阅书名 Search
	 */

    public void setTsTypes(Integer tsTypes) {
        this.tsTypes = tsTypes;
    }
    /**
	 * 设置：图书类别 Search
	 */
    public Integer getLbTypes() {
        return lbTypes;
    }


    /**
	 * 获取：图书类别 Search
	 */

    public void setLbTypes(Integer lbTypes) {
        this.lbTypes = lbTypes;
    }
    /**
	 * 设置：图书出版社 Search
	 */
    public Integer getCbsTypes() {
        return cbsTypes;
    }


    /**
	 * 获取：图书出版社 Search
	 */

    public void setCbsTypes(Integer cbsTypes) {
        this.cbsTypes = cbsTypes;
    }
    /**
	 * 设置：所在书架 Search
	 */
    public Integer getSjTypes() {
        return sjTypes;
    }


    /**
	 * 获取：所在书架 Search
	 */

    public void setSjTypes(Integer sjTypes) {
        this.sjTypes = sjTypes;
    }
    /**
	 * 设置：借阅时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：借阅时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

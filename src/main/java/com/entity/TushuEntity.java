package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 图书表
 *
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("tushu")
public class TushuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuEntity() {

	}

	public TushuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 图书编号 Search
     */
    @TableField(value = "serial")
    private String serial;


    /**
     * 图书名称 Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 图书作者
     */
    @TableField(value = "author")
    private String author;


    /**
     * 图书类别 Search
     */
    @TableField(value = "lb_types")
    private Integer lbTypes;


    /**
     * 图书出版社 Search
     */
    @TableField(value = "cbs_types")
    private Integer cbsTypes;


    /**
     * 所在书架 Search
     */
    @TableField(value = "sj_types")
    private Integer sjTypes;


    /**
     * 是否借阅 Search
     */
    @TableField(value = "sf_types")
    private Integer sfTypes;


    /**
     * 图书添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
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
	 * 设置：图书编号 Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：图书编号 Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：图书名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：图书名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：图书作者
	 */
    public String getAuthor() {
        return author;
    }


    /**
	 * 获取：图书作者
	 */

    public void setAuthor(String author) {
        this.author = author;
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
	 * 设置：是否借阅 Search
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否借阅 Search
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }
    /**
	 * 设置：图书添加时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：图书添加时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

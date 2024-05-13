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
 * 借阅表
 *
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("jieyue")
public class JieyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JieyueEntity() {

	}

	public JieyueEntity(T t) {
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
     * 借阅人 Search
     */
    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 借阅书名 Search
     */
    @TableField(value = "ts_types")
    private Integer tsTypes;


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
     * 借阅时间
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

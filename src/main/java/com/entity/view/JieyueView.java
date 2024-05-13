package com.entity.view;

import com.entity.JieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 借阅表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("jieyue")
public class JieyueView extends JieyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public JieyueView() {

	}

	public JieyueView(JieyueEntity jieyueEntity) {
		try {
			BeanUtils.copyProperties(this, jieyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

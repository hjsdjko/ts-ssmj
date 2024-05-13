package com.entity.view;

import com.entity.ShujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 书架表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("shujia")
public class ShujiaView extends ShujiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShujiaView() {

	}

	public ShujiaView(ShujiaEntity shujiaEntity) {
		try {
			BeanUtils.copyProperties(this, shujiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShujiaEntity;
import java.util.Map;

/**
 * 书架表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface ShujiaService extends IService<ShujiaEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
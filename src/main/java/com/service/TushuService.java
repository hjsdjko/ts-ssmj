package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushuEntity;
import java.util.Map;

/**
 * 图书表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface TushuService extends IService<TushuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
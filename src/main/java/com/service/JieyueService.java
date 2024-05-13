package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieyueEntity;
import java.util.Map;

/**
 * 借阅表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface JieyueService extends IService<JieyueEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
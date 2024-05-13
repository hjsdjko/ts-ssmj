package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChubansheEntity;
import java.util.Map;

/**
 * 图书出版社表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface ChubansheService extends IService<ChubansheEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.TushuDao;
import com.entity.TushuEntity;
import com.service.TushuService;
import com.entity.view.TushuView;

/**
 * 图书表 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("tushuService")
@Transactional
public class TushuServiceImpl extends ServiceImpl<TushuDao, TushuEntity> implements TushuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<TushuView> page =new Query<TushuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

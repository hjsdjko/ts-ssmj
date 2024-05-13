package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ChubansheDao;
import com.entity.ChubansheEntity;
import com.service.ChubansheService;
import com.entity.view.ChubansheView;

/**
 * 图书出版社表 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("chubansheService")
@Transactional
public class ChubansheServiceImpl extends ServiceImpl<ChubansheDao, ChubansheEntity> implements ChubansheService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChubansheView> page =new Query<ChubansheView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.JieyueEntity;
import com.service.JieyueService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.TushuEntity;

import com.service.TushuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 图书表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-25
*/
@RestController
@Controller
@RequestMapping("/tushu")
public class TushuController {
    private static final Logger logger = LoggerFactory.getLogger(TushuController.class);

    @Autowired
    private TushuService tushuService;

    @Autowired
    private JieyueService jieyueService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = tushuService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        TushuEntity tushu = tushuService.selectById(id);
        if(tushu!=null){
            return R.ok().put("data", tushu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TushuEntity tushu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<TushuEntity> queryWrapper = new EntityWrapper<TushuEntity>()
            .eq("serial", tushu.getSerial())
            .eq("name", tushu.getName())
            .eq("author", tushu.getAuthor())
            .eq("lb_types", tushu.getLbTypes())
            .eq("cbs_types", tushu.getCbsTypes())
            .eq("sj_types", tushu.getSjTypes())
            .eq("sf_types", tushu.getSfTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TushuEntity tushuEntity = tushuService.selectOne(queryWrapper);
        if(tushuEntity==null){
            tushu.setSfTypes(1);
            tushuService.insert(tushu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TushuEntity tushu){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<TushuEntity> queryWrapper = new EntityWrapper<TushuEntity>()
            .notIn("id",tushu.getId())
            .eq("serial", tushu.getSerial())
            .eq("name", tushu.getName())
            .eq("author", tushu.getAuthor())
            .eq("lb_types", tushu.getLbTypes())
            .eq("cbs_types", tushu.getCbsTypes())
            .eq("sj_types", tushu.getSjTypes())
            .eq("sf_types", tushu.getSfTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TushuEntity tushuEntity = tushuService.selectOne(queryWrapper);
        if(tushuEntity==null){
            tushuService.updateById(tushu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/borrowBooks")
    public R borrowBooks(@RequestBody Long ids, HttpServletRequest request){
        TushuEntity tushu= tushuService.selectById(ids);
        if(tushu.getSfTypes() == 2){
            return R.error("这本书已经借阅出去了哦");
        }
        if(tushu != null){
            JieyueEntity jieyue = new JieyueEntity();
            jieyue.setCbsTypes(tushu.getCbsTypes());
            jieyue.setCreateTime(new Date());
            jieyue.setLbTypes(tushu.getLbTypes());
            jieyue.setSjTypes(tushu.getSjTypes());
            jieyue.setTsTypes(tushu.getId());
            jieyue.setYhTypes((Integer) request.getSession().getAttribute("userId"));
            Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
                    .eq("yh_types", jieyue.getYhTypes())
                    .eq("ts_types", jieyue.getTsTypes())
                    .eq("lb_types", jieyue.getLbTypes())
                    .eq("cbs_types", jieyue.getCbsTypes())
                    .eq("sj_types", jieyue.getSjTypes())
                    ;
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
            if(jieyueEntity==null){
                jieyueService.insert(jieyue);
                tushu.setSfTypes(2);
                tushuService.updateById(tushu);
                return R.ok();
            }else {
                return R.error(511,"你已经借过这本书了");
            }
        }else{
            return R.error("图书不存在");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        tushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


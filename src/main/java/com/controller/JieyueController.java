package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.TushuEntity;
import com.service.TushuService;
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

import com.entity.JieyueEntity;

import com.service.JieyueService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 借阅表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-25
*/
@RestController
@Controller
@RequestMapping("/jieyue")
public class JieyueController {
    private static final Logger logger = LoggerFactory.getLogger(JieyueController.class);

    @Autowired
    private JieyueService jieyueService;

    @Autowired
    private TushuService tushuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = jieyueService.queryPage(params);
        }else{
            page = jieyueService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JieyueEntity jieyue = jieyueService.selectById(id);
        if(jieyue!=null){
            return R.ok().put("data", jieyue);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JieyueEntity jieyue, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
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
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JieyueEntity jieyue, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
            .notIn("id",jieyue.getId())
            .eq("yh_types", jieyue.getYhTypes())
            .eq("ts_types", jieyue.getTsTypes())
            .eq("lb_types", jieyue.getLbTypes())
            .eq("cbs_types", jieyue.getCbsTypes())
            .eq("sj_types", jieyue.getSjTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
        if(jieyueEntity==null){
            jieyueService.updateById(jieyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 还书
     */
    @RequestMapping("/returnABook")
    public R returnABook(@RequestBody Integer ids){
        JieyueEntity jieyue = jieyueService.selectById(ids);
        if(jieyue != null){
            TushuEntity tushu = tushuService.selectById(jieyue.getTsTypes());
            if(tushu != null){
                tushu.setSfTypes(1);
                tushuService.updateById(tushu);
                jieyueService.deleteById(ids);
                return R.ok();
            }else{
                return R.error("这本书不存在");
            }
        }else{
            return R.error("这本书不存在");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        jieyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


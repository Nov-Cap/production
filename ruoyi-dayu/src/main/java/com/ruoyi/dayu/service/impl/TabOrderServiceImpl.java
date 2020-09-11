package com.ruoyi.dayu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dayu.mapper.TabOrderMapper;
import com.ruoyi.dayu.domain.TabOrder;
import com.ruoyi.dayu.service.ITabOrderService;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
@Service
public class TabOrderServiceImpl implements ITabOrderService 
{
    @Autowired
    private TabOrderMapper tabOrderMapper;

    /**
     * 查询订单信息
     * 
     * @param id 订单信息ID
     * @return 订单信息
     */
    @Override
    public TabOrder selectTabOrderById(Long id)
    {
        return tabOrderMapper.selectTabOrderById(id);
    }

    /**
     * 查询订单信息列表
     * 
     * @param tabOrder 订单信息
     * @return 订单信息
     */
    @Override
    public List<TabOrder> selectTabOrderList(TabOrder tabOrder)
    {
        return tabOrderMapper.selectTabOrderList(tabOrder);
    }

    /**
     * 新增订单信息
     * 
     * @param tabOrder 订单信息
     * @return 结果
     */
    @Override
    public int insertTabOrder(TabOrder tabOrder)
    {
        tabOrder.setCreateTime(DateUtils.getNowDate());
        return tabOrderMapper.insertTabOrder(tabOrder);
    }

    /**
     * 修改订单信息
     * 
     * @param tabOrder 订单信息
     * @return 结果
     */
    @Override
    public int updateTabOrder(TabOrder tabOrder)
    {
        tabOrder.setUpdateTime(DateUtils.getNowDate());
        return tabOrderMapper.updateTabOrder(tabOrder);
    }

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的订单信息ID
     * @return 结果
     */
    @Override
    public int deleteTabOrderByIds(Long[] ids)
    {
        return tabOrderMapper.deleteTabOrderByIds(ids);
    }

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息ID
     * @return 结果
     */
    @Override
    public int deleteTabOrderById(Long id)
    {
        return tabOrderMapper.deleteTabOrderById(id);
    }
}

package com.ruoyi.dayu.service;

import java.util.List;
import com.ruoyi.dayu.domain.TabOrder;

/**
 * 订单信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
public interface ITabOrderService 
{
    /**
     * 查询订单信息
     * 
     * @param id 订单信息ID
     * @return 订单信息
     */
    public TabOrder selectTabOrderById(Long id);

    /**
     * 查询订单信息列表
     * 
     * @param tabOrder 订单信息
     * @return 订单信息集合
     */
    public List<TabOrder> selectTabOrderList(TabOrder tabOrder);

    /**
     * 新增订单信息
     * 
     * @param tabOrder 订单信息
     * @return 结果
     */
    public int insertTabOrder(TabOrder tabOrder);

    /**
     * 修改订单信息
     * 
     * @param tabOrder 订单信息
     * @return 结果
     */
    public int updateTabOrder(TabOrder tabOrder);

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的订单信息ID
     * @return 结果
     */
    public int deleteTabOrderByIds(Long[] ids);

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息ID
     * @return 结果
     */
    public int deleteTabOrderById(Long id);
}

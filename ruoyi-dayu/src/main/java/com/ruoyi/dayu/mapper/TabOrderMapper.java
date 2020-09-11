package com.ruoyi.dayu.mapper;

import java.util.List;
import com.ruoyi.dayu.domain.TabOrder;

/**
 * 订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
public interface TabOrderMapper 
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
     * 删除订单信息
     * 
     * @param id 订单信息ID
     * @return 结果
     */
    public int deleteTabOrderById(Long id);

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTabOrderByIds(Long[] ids);
}

package com.ruoyi.dayu.service;

import java.util.List;
import com.ruoyi.dayu.domain.TabProductInfo;

/**
 * 产品信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public interface ITabProductInfoService 
{
    /**
     * 查询产品信息
     * 
     * @param id 产品信息ID
     * @return 产品信息
     */
    public TabProductInfo selectTabProductInfoById(Long id);

    /**
     * 查询产品信息列表
     * 
     * @param tabProductInfo 产品信息
     * @return 产品信息集合
     */
    public List<TabProductInfo> selectTabProductInfoList(TabProductInfo tabProductInfo);

    /**
     * 新增产品信息
     * 
     * @param tabProductInfo 产品信息
     * @return 结果
     */
    public int insertTabProductInfo(TabProductInfo tabProductInfo);

    /**
     * 修改产品信息
     * 
     * @param tabProductInfo 产品信息
     * @return 结果
     */
    public int updateTabProductInfo(TabProductInfo tabProductInfo);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息ID
     * @return 结果
     */
    public int deleteTabProductInfoByIds(Long[] ids);

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    public int deleteTabProductInfoById(Long id);
}

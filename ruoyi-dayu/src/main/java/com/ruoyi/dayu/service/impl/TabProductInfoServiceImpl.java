package com.ruoyi.dayu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dayu.mapper.TabProductInfoMapper;
import com.ruoyi.dayu.domain.TabProductInfo;
import com.ruoyi.dayu.service.ITabProductInfoService;

/**
 * 产品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@Service
public class TabProductInfoServiceImpl implements ITabProductInfoService 
{
    @Autowired
    private TabProductInfoMapper tabProductInfoMapper;

    /**
     * 查询产品信息
     * 
     * @param id 产品信息ID
     * @return 产品信息
     */
    @Override
    public TabProductInfo selectTabProductInfoById(Long id)
    {
        return tabProductInfoMapper.selectTabProductInfoById(id);
    }

    /**
     * 查询产品信息列表
     * 
     * @param tabProductInfo 产品信息
     * @return 产品信息
     */
    @Override
    public List<TabProductInfo> selectTabProductInfoList(TabProductInfo tabProductInfo)
    {
        return tabProductInfoMapper.selectTabProductInfoList(tabProductInfo);
    }

    /**
     * 新增产品信息
     * 
     * @param tabProductInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertTabProductInfo(TabProductInfo tabProductInfo)
    {
        tabProductInfo.setCreateTime(DateUtils.getNowDate());
        tabProductInfo.setCreateBy(String.valueOf(SecurityUtils.getSysUser().getUserId()));
        return tabProductInfoMapper.insertTabProductInfo(tabProductInfo);
    }

    /**
     * 修改产品信息
     * 
     * @param tabProductInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateTabProductInfo(TabProductInfo tabProductInfo)
    {
        tabProductInfo.setUpdateTime(DateUtils.getNowDate());
        tabProductInfo.setUpdateBy(String.valueOf(SecurityUtils.getSysUser().getUserId()));
        return tabProductInfoMapper.updateTabProductInfo(tabProductInfo);
    }

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息ID
     * @return 结果
     */
    @Override
    public int deleteTabProductInfoByIds(Long[] ids)
    {
        return tabProductInfoMapper.deleteTabProductInfoByIds(ids);
    }

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteTabProductInfoById(Long id)
    {
        return tabProductInfoMapper.deleteTabProductInfoById(id);
    }
}

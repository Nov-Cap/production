package com.ruoyi.dayu.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dayu.mapper.TabCustomerInformationMapper;
import com.ruoyi.dayu.domain.TabCustomerInformation;
import com.ruoyi.dayu.service.ITabCustomerInformationService;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@Service
public class TabCustomerInformationServiceImpl implements ITabCustomerInformationService 
{
    @Autowired
    private TabCustomerInformationMapper tabCustomerInformationMapper;

    /**
     * 根据汉字模糊查询公司信息
     *
     * @param customerName 客户公司名称
     * @return 客户信息集合
     * */
    @Override
    public List<TabCustomerInformation> getCustomerNameByLikeName(String customerName) {
        return tabCustomerInformationMapper.getCustomerNameByLikeName(customerName);
    }

    /**
     * 查询客户信息
     * 
     * @param id 客户信息ID
     * @return 客户信息
     */
    @Override
    public TabCustomerInformation selectTabCustomerInformationById(Long id)
    {
        return tabCustomerInformationMapper.selectTabCustomerInformationById(id);
    }

    /**
     * 查询客户信息列表
     * 
     * @param tabCustomerInformation 客户信息
     * @return 客户信息
     */
    @Override
    public List<TabCustomerInformation> selectTabCustomerInformationList(TabCustomerInformation tabCustomerInformation)
    {
        return tabCustomerInformationMapper.selectTabCustomerInformationList(tabCustomerInformation);
    }

    /**
     * 新增客户信息
     * 
     * @param tabCustomerInformation 客户信息
     * @return 结果
     */
    @Override
    public int insertTabCustomerInformation(TabCustomerInformation tabCustomerInformation)
    {
        tabCustomerInformation.setCreateTime(DateUtils.getNowDate());
        Long userId = SecurityUtils.getSysUser().getUserId();
        tabCustomerInformation.setCreateBy(String.valueOf(userId));
        return tabCustomerInformationMapper.insertTabCustomerInformation(tabCustomerInformation);
    }

    /**
     * 修改客户信息
     * 
     * @param tabCustomerInformation 客户信息
     * @return 结果
     */
    @Override
    public int updateTabCustomerInformation(TabCustomerInformation tabCustomerInformation)
    {
        tabCustomerInformation.setUpdateTime(DateUtils.getNowDate());
        Long userId = SecurityUtils.getSysUser().getUserId();
        tabCustomerInformation.setUpdateBy(String.valueOf(userId));
        return tabCustomerInformationMapper.updateTabCustomerInformation(tabCustomerInformation);
    }

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的客户信息ID
     * @return 结果
     */
    @Override
    public int deleteTabCustomerInformationByIds(Long[] ids)
    {
        return tabCustomerInformationMapper.deleteTabCustomerInformationByIds(ids);
    }

    /**
     * 删除客户信息信息
     * 
     * @param id 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteTabCustomerInformationById(Long id)
    {
        return tabCustomerInformationMapper.deleteTabCustomerInformationById(id);
    }
}

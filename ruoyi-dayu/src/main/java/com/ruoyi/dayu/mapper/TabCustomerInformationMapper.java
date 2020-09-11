package com.ruoyi.dayu.mapper;

import java.util.List;
import com.ruoyi.dayu.domain.TabCustomerInformation;
import org.apache.ibatis.annotations.Param;

/**
 * 客户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public interface TabCustomerInformationMapper 
{
    /**
    * 根据汉字模糊查询公司信息
    *
    * @param customerName 客户公司名称
    * @return 客户信息集合
    * */
    public List<TabCustomerInformation> getCustomerNameByLikeName(@Param("customerName") String customerName);

    /**
     * 查询客户信息
     * 
     * @param id 客户信息ID
     * @return 客户信息
     */
    public TabCustomerInformation selectTabCustomerInformationById(Long id);

    /**
     * 查询客户信息列表
     * 
     * @param tabCustomerInformation 客户信息
     * @return 客户信息集合
     */
    public List<TabCustomerInformation> selectTabCustomerInformationList(TabCustomerInformation tabCustomerInformation);

    /**
     * 新增客户信息
     * 
     * @param tabCustomerInformation 客户信息
     * @return 结果
     */
    public int insertTabCustomerInformation(TabCustomerInformation tabCustomerInformation);

    /**
     * 修改客户信息
     * 
     * @param tabCustomerInformation 客户信息
     * @return 结果
     */
    public int updateTabCustomerInformation(TabCustomerInformation tabCustomerInformation);

    /**
     * 删除客户信息
     * 
     * @param id 客户信息ID
     * @return 结果
     */
    public int deleteTabCustomerInformationById(Long id);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTabCustomerInformationByIds(Long[] ids);
}

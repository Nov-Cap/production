package com.ruoyi.web.controller.dayu;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.dayu.domain.TabCustomerInformation;
import com.ruoyi.dayu.service.ITabCustomerInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@RestController
@RequestMapping("/dayu/customerIncformation")
public class TabCustomerInformationController extends BaseController
{
    @Autowired
    private ITabCustomerInformationService tabCustomerInformationService;

    /**
     * 根据汉字模糊查询公司信息
     *
     * @param customerName 客户公司名称
     * @return 客户信息集合
     * */
    @GetMapping(value = {"/getCustomerName"})
    public  AjaxResult getCustomerNameList(String customerName){
        return AjaxResult.success(tabCustomerInformationService.getCustomerNameByLikeName(customerName));
    }

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabCustomerInformation tabCustomerInformation)
    {
        startPage();
        List<TabCustomerInformation> list = tabCustomerInformationService.selectTabCustomerInformationList(tabCustomerInformation);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TabCustomerInformation tabCustomerInformation)
    {
        List<TabCustomerInformation> list = tabCustomerInformationService.selectTabCustomerInformationList(tabCustomerInformation);
        ExcelUtil<TabCustomerInformation> util = new ExcelUtil<TabCustomerInformation>(TabCustomerInformation.class);
        return util.exportExcel(list, "customerIncformation");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tabCustomerInformationService.selectTabCustomerInformationById(id));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TabCustomerInformation tabCustomerInformation)
    {
        Long userId = SecurityUtils.getSysUser().getUserId();
        tabCustomerInformation.setCreateBy(String.valueOf(userId));
        tabCustomerInformation.setUpdateBy(String.valueOf(userId));
        return toAjax(tabCustomerInformationService.insertTabCustomerInformation(tabCustomerInformation));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TabCustomerInformation tabCustomerInformation)
    {
        return toAjax(tabCustomerInformationService.updateTabCustomerInformation(tabCustomerInformation));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:customerIncformation:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tabCustomerInformationService.deleteTabCustomerInformationByIds(ids));
    }
}

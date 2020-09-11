package com.ruoyi.web.controller.dayu;

import java.util.List;

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
import com.ruoyi.dayu.domain.TabProductInfo;
import com.ruoyi.dayu.service.ITabProductInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@RestController
@RequestMapping("/dayu/productInfo")
public class TabProductInfoController extends BaseController
{
    @Autowired
    private ITabProductInfoService tabProductInfoService;

    /**
     * 查询产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabProductInfo tabProductInfo)
    {
        startPage();
        List<TabProductInfo> list = tabProductInfoService.selectTabProductInfoList(tabProductInfo);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:export')")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TabProductInfo tabProductInfo)
    {
        List<TabProductInfo> list = tabProductInfoService.selectTabProductInfoList(tabProductInfo);
        ExcelUtil<TabProductInfo> util = new ExcelUtil<TabProductInfo>(TabProductInfo.class);
        return util.exportExcel(list, "productInfo");
    }

    /**
     * 获取产品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tabProductInfoService.selectTabProductInfoById(id));
    }

    /**
     * 新增产品信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:add')")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TabProductInfo tabProductInfo)
    {
        return toAjax(tabProductInfoService.insertTabProductInfo(tabProductInfo));
    }

    /**
     * 修改产品信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:edit')")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TabProductInfo tabProductInfo)
    {
        return toAjax(tabProductInfoService.updateTabProductInfo(tabProductInfo));
    }

    /**
     * 删除产品信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:productInfo:remove')")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tabProductInfoService.deleteTabProductInfoByIds(ids));
    }
}

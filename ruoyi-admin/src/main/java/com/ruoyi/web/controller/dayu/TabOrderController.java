package com.ruoyi.web.controller.dayu;

import java.util.List;
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
import com.ruoyi.dayu.domain.TabOrder;
import com.ruoyi.dayu.service.ITabOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@RestController
@RequestMapping("/dayu/task_order")
public class TabOrderController extends BaseController
{
    @Autowired
    private ITabOrderService tabOrderService;

    /**
     * 查询订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabOrder tabOrder)
    {
        startPage();
        List<TabOrder> list = tabOrderService.selectTabOrderList(tabOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:export')")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TabOrder tabOrder)
    {
        List<TabOrder> list = tabOrderService.selectTabOrderList(tabOrder);
        ExcelUtil<TabOrder> util = new ExcelUtil<TabOrder>(TabOrder.class);
        return util.exportExcel(list, "task_order");
    }

    /**
     * 获取订单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tabOrderService.selectTabOrderById(id));
    }

    /**
     * 新增订单信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:add')")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TabOrder tabOrder)
    {
        return toAjax(tabOrderService.insertTabOrder(tabOrder));
    }

    /**
     * 修改订单信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:edit')")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TabOrder tabOrder)
    {
        return toAjax(tabOrderService.updateTabOrder(tabOrder));
    }

    /**
     * 删除订单信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:task_order:remove')")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tabOrderService.deleteTabOrderByIds(ids));
    }
}

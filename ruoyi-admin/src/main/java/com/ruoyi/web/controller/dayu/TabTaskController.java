package com.ruoyi.web.controller.dayu;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dayu.domain.TabTask;
import com.ruoyi.dayu.service.ITabTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 大禹Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@RestController
@RequestMapping("/dayu/task")
public class TabTaskController extends BaseController
{
    @Autowired
    private ITabTaskService tabTaskService;

    /**
     * 查询大禹列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(TabTask tabTask)
    {
        startPage();
        List<TabTask> list = tabTaskService.selectTabTaskList(tabTask);
        return getDataTable(list);
    }

    /**
     * 导出大禹列表
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:export')")
    @Log(title = "大禹", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TabTask tabTask)
    {
        List<TabTask> list = tabTaskService.selectTabTaskList(tabTask);
        ExcelUtil<TabTask> util = new ExcelUtil<TabTask>(TabTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 获取大禹详细信息
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tabTaskService.selectTabTaskById(id));
    }

    /**
     * 新增大禹
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:add')")
    @Log(title = "大禹", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TabTask tabTask)
    {
        return toAjax(tabTaskService.insertTabTask(tabTask));
    }

    /**
     * 修改大禹
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:edit')")
    @Log(title = "大禹", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TabTask tabTask)
    {
        return toAjax(tabTaskService.updateTabTask(tabTask));
    }

    /**
     * 删除大禹
     */
    @PreAuthorize("@ss.hasPermi('dayu:task:remove')")
    @Log(title = "大禹", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tabTaskService.deleteTabTaskByIds(ids));
    }
}

package com.ruoyi.dayu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dayu.mapper.TabTaskMapper;
import com.ruoyi.dayu.domain.TabTask;
import com.ruoyi.dayu.service.ITabTaskService;

/**
 * 任务表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@Service
public class TabTaskServiceImpl implements ITabTaskService 
{
    @Autowired
    private TabTaskMapper tabTaskMapper;

    /**
     * 查询任务表
     * 
     * @param id 任务表ID
     * @return 任务表
     */
    @Override
    public TabTask selectTabTaskById(Long id)
    {
        return tabTaskMapper.selectTabTaskById(id);
    }

    /**
     * 查询任务表列表
     * 
     * @param tabTask 任务表
     * @return 任务表
     */
    @Override
    public List<TabTask> selectTabTaskList(TabTask tabTask)
    {
        return tabTaskMapper.selectTabTaskList(tabTask);
    }

    /**
     * 新增任务表
     * 
     * @param tabTask 任务表
     * @return 结果
     */
    @Override
    public int insertTabTask(TabTask tabTask)
    {
        tabTask.setCreateTime(DateUtils.getNowDate());
        return tabTaskMapper.insertTabTask(tabTask);
    }

    /**
     * 修改任务表
     * 
     * @param tabTask 任务表
     * @return 结果
     */
    @Override
    public int updateTabTask(TabTask tabTask)
    {
        tabTask.setUpdateTime(DateUtils.getNowDate());
        return tabTaskMapper.updateTabTask(tabTask);
    }

    /**
     * 批量删除任务表
     * 
     * @param ids 需要删除的任务表ID
     * @return 结果
     */
    @Override
    public int deleteTabTaskByIds(Long[] ids)
    {
        return tabTaskMapper.deleteTabTaskByIds(ids);
    }

    /**
     * 删除任务表信息
     * 
     * @param id 任务表ID
     * @return 结果
     */
    @Override
    public int deleteTabTaskById(Long id)
    {
        return tabTaskMapper.deleteTabTaskById(id);
    }
}

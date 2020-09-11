package com.ruoyi.dayu.service;

import java.util.List;
import com.ruoyi.dayu.domain.TabTask;

/**
 * 任务表Service接口
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public interface ITabTaskService 
{
    /**
     * 查询任务表
     * 
     * @param id 任务表ID
     * @return 任务表
     */
    public TabTask selectTabTaskById(Long id);

    /**
     * 查询任务表列表
     * 
     * @param tabTask 任务表
     * @return 任务表集合
     */
    public List<TabTask> selectTabTaskList(TabTask tabTask);

    /**
     * 新增任务表
     * 
     * @param tabTask 任务表
     * @return 结果
     */
    public int insertTabTask(TabTask tabTask);

    /**
     * 修改任务表
     * 
     * @param tabTask 任务表
     * @return 结果
     */
    public int updateTabTask(TabTask tabTask);

    /**
     * 批量删除任务表
     * 
     * @param ids 需要删除的任务表ID
     * @return 结果
     */
    public int deleteTabTaskByIds(Long[] ids);

    /**
     * 删除任务表信息
     * 
     * @param id 任务表ID
     * @return 结果
     */
    public int deleteTabTaskById(Long id);
}

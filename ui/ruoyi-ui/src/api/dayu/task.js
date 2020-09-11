import request from '@/utils/request'

// 查询大禹列表
export function listTask(query) {
  return request({
    url: '/dayu/task/list',
    method: 'get',
    params: query
  })
}

// 查询大禹详细
export function getTask(id) {
  return request({
    url: '/dayu/task/' + id,
    method: 'get'
  })
}

// 新增大禹
export function addTask(data) {
  return request({
    url: '/dayu/task',
    method: 'post',
    data: data
  })
}

// 修改大禹
export function updateTask(data) {
  return request({
    url: '/dayu/task',
    method: 'put',
    data: data
  })
}

// 删除大禹
export function delTask(id) {
  return request({
    url: '/dayu/task/' + id,
    method: 'delete'
  })
}

// 导出大禹
export function exportTask(query) {
  return request({
    url: '/dayu/task/export',
    method: 'get',
    params: query
  })
}
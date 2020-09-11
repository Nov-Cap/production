import request from '@/utils/request'

// 查询订单信息列表
export function listTask_order(query) {
  return request({
    url: '/dayu/task_order/list',
    method: 'get',
    params: query
  })
}

// 查询订单信息详细
export function getTask_order(id) {
  return request({
    url: '/dayu/task_order/' + id,
    method: 'get'
  })
}

// 新增订单信息
export function addTask_order(data) {
  return request({
    url: '/dayu/task_order',
    method: 'post',
    data: data
  })
}

// 修改订单信息
export function updateTask_order(data) {
  return request({
    url: '/dayu/task_order',
    method: 'put',
    data: data
  })
}

// 删除订单信息
export function delTask_order(id) {
  return request({
    url: '/dayu/task_order/' + id,
    method: 'delete'
  })
}

// 导出订单信息
export function exportTask_order(query) {
  return request({
    url: '/dayu/task_order/export',
    method: 'get',
    params: query
  })
}
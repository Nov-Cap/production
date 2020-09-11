import request from '@/utils/request'

// 查询客户信息列表
export function listCustomerIncformation(query) {
  return request({
    url: '/dayu/customerIncformation/list',
    method: 'get',
    params: query
  })
}

// 查询客户信息详细
export function getCustomerIncformation(id) {
  return request({
    url: '/dayu/customerIncformation/' + id,
    method: 'get'
  })
}

// 新增客户信息
export function addCustomerIncformation(data) {
  return request({
    url: '/dayu/customerIncformation',
    method: 'post',
    data: data
  })
}

// 修改客户信息
export function updateCustomerIncformation(data) {
  return request({
    url: '/dayu/customerIncformation',
    method: 'put',
    data: data
  })
}

// 删除客户信息
export function delCustomerIncformation(id) {
  return request({
    url: '/dayu/customerIncformation/' + id,
    method: 'delete'
  })
}

// 导出客户信息
export function exportCustomerIncformation(query) {
  return request({
    url: '/dayu/customerIncformation/export',
    method: 'get',
    params: query
  })
}
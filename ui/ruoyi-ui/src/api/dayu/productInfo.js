import request from '@/utils/request'

// 查询产品信息列表
export function listProductInfo(query) {
  return request({
    url: '/dayu/productInfo/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息详细
export function getProductInfo(id) {
  return request({
    url: '/dayu/productInfo/' + id,
    method: 'get'
  })
}

// 新增产品信息
export function addProductInfo(data) {
  return request({
    url: '/dayu/productInfo',
    method: 'post',
    data: data
  })
}

// 修改产品信息
export function updateProductInfo(data) {
  return request({
    url: '/dayu/productInfo',
    method: 'put',
    data: data
  })
}

// 删除产品信息
export function delProductInfo(id) {
  return request({
    url: '/dayu/productInfo/' + id,
    method: 'delete'
  })
}

// 导出产品信息
export function exportProductInfo(query) {
  return request({
    url: '/dayu/productInfo/export',
    method: 'get',
    params: query
  })
}
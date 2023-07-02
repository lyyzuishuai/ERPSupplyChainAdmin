package com.ruoyi.production.service;

import java.util.List;

import com.ruoyi.production.domain.OperationProduct;
import com.ruoyi.production.vo.OperationProductVo;

/**
 * 成品入库Service接口
 *
 * @author jia
 * @date 2022-12-12
 */
public interface IOperationProductService
{
    /**
     * 查询成品入库
     *
     * @param operationProductId 成品入库主键
     * @return 成品入库
     */
    public OperationProduct selectOperationProductByOperationProductId(Integer operationProductId);

    /**
     * 查询成品入库列表
     *
     * @param operationProduct 成品入库
     * @return 成品入库集合
     */
    public List<OperationProduct> selectOperationProductList(OperationProduct operationProduct);

    /**
     * 新增成品入库
     *
     * @param operationProduct 成品入库
     * @return 结果
     */
    public int insertOperationProduct(OperationProduct operationProduct);

    /**
     * 修改成品入库
     *
     * @param operationProduct 成品入库
     * @return 结果
     */
    public int updateOperationProduct(OperationProduct operationProduct);

    /**
     * 批量删除成品入库
     *
     * @param operationProductIds 需要删除的成品入库主键集合
     * @return 结果
     */
    public int deleteOperationProductByOperationProductIds(Integer[] operationProductIds);

    /**
     * 删除成品入库信息
     *
     * @param operationProductId 成品入库主键
     * @return 结果
     */
    public int deleteOperationProductByOperationProductId(Integer operationProductId);

    public  int chonseOperationProduct(OperationProductVo operationProductVo);

    public int auditOperationProduct(OperationProductVo operationProductVo);

    public int approverOperationProduct(OperationProductVo operationProductVo);
}
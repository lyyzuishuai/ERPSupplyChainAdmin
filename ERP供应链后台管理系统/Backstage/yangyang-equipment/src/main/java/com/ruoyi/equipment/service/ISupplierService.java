package com.ruoyi.equipment.service;

import java.util.List;

import com.ruoyi.equipment.domain.Supplier;
import com.ruoyi.equipment.vo.SupplierVo;

/**
 * 供应商Service接口
 *
 * @author jia
 * @date 2022-11-24
 */
public interface ISupplierService
{
    /**
     * 查询供应商
     *
     * @param supplierId 供应商主键
     * @return 供应商
     */
    public Supplier selectSupplierBySupplierId(Integer supplierId);

    /**
     * 查询供应商列表
     *
     * @param supplier 供应商
     * @return 供应商集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商
     *
     * @param supplier 供应商
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供应商
     *
     * @param supplier 供应商
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 批量删除供应商
     *
     * @param supplierIds 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(Integer[] supplierIds);

    /**
     * 删除供应商信息
     *
     * @param supplierId 供应商主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Integer supplierId);

    public int auditSupplier(SupplierVo suppliervo);

    public int approverSupplier(SupplierVo suppliervo);
}
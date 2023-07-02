package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ClassesProduct;

/**
 * 成品分类Mapper接口
 *
 * @author jia
 * @date 2022-12-10
 */
public interface ClassesProductMapper
{
    /**
     * 查询成品分类
     *
     * @param classesProductId 成品分类主键
     * @return 成品分类
     */
    public ClassesProduct selectClassesProductByClassesProductId(Integer classesProductId);

    /**
     * 查询成品分类列表
     *
     * @param classesProduct 成品分类
     * @return 成品分类集合
     */
    public List<ClassesProduct> selectClassesProductList(ClassesProduct classesProduct);

    /**
     * 新增成品分类
     *
     * @param classesProduct 成品分类
     * @return 结果
     */
    public int insertClassesProduct(ClassesProduct classesProduct);

    /**
     * 修改成品分类
     *
     * @param classesProduct 成品分类
     * @return 结果
     */
    public int updateClassesProduct(ClassesProduct classesProduct);

    /**
     * 删除成品分类
     *
     * @param classesProductId 成品分类主键
     * @return 结果
     */
    public int deleteClassesProductByClassesProductId(Integer classesProductId);

    /**
     * 批量删除成品分类
     *
     * @param classesProductIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassesProductByClassesProductIds(Integer[] classesProductIds);
}
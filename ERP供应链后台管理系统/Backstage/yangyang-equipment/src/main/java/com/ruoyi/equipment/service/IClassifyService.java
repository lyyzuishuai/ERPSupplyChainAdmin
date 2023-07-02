package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.Classify;

import java.util.List;

/**
 * 供应商分类Service接口
 *
 * @author jiazhixian
 * @date 2022-11-23
 */
public interface IClassifyService
{
    /**
     * 查询供应商分类
     *
     * @param classifyId 供应商分类主键
     * @return 供应商分类
     */
    public Classify selectClassifyByClassifyId(Integer classifyId);

    /**
     * 查询供应商分类列表
     *
     * @param classify 供应商分类
     * @return 供应商分类集合
     */
    public List<Classify> selectClassifyList(Classify classify);

    /**
     * 新增供应商分类
     *
     * @param classify 供应商分类
     * @return 结果
     */
    public int insertClassify(Classify classify);

    /**
     * 修改供应商分类
     *
     * @param classify 供应商分类
     * @return 结果
     */
    public int updateClassify(Classify classify);

    /**
     * 批量删除供应商分类
     *
     * @param classifyIds 需要删除的供应商分类主键集合
     * @return 结果
     */
    public int deleteClassifyByClassifyIds(Integer[] classifyIds);

    /**
     * 删除供应商分类信息
     *
     * @param classifyId 供应商分类主键
     * @return 结果
     */
    public int deleteClassifyByClassifyId(Integer classifyId);
}
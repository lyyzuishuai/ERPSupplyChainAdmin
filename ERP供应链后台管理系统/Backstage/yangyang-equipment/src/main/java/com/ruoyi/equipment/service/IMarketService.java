package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.Market;
import com.ruoyi.equipment.vo.MarketVo;

import java.util.List;

/**
 * marketService接口
 *
 * @author jia
 * @date 2022-12-18
 */
public interface IMarketService
{
    /**
     * 查询market
     *
     * @param marketId market主键
     * @return market
     */
    public Market selectMarketByMarketId(Integer marketId);

    /**
     * 查询market列表
     *
     * @param market market
     * @return market集合
     */
    public List<Market> selectMarketList(Market market);

    /**
     * 新增market
     *
     * @param market market
     * @return 结果
     */
    public int insertMarket(Market market);

    /**
     * 修改market
     *
     * @param market market
     * @return 结果
     */
    public int updateMarket(Market market);

    /**
     * 批量删除market
     *
     * @param marketIds 需要删除的market主键集合
     * @return 结果
     */
    public int deleteMarketByMarketIds(Integer[] marketIds);

    /**
     * 删除market信息
     *
     * @param marketId market主键
     * @return 结果
     */
    public int deleteMarketByMarketId(Integer marketId);

    public int auditMarket(MarketVo marketVo);

    public int approverMarket(MarketVo marketVo);
}
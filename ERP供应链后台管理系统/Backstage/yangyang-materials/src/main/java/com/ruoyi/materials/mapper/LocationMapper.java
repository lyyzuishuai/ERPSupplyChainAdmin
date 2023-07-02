package com.ruoyi.materials.mapper;

import java.util.List;
import com.ruoyi.materials.domain.Location;

/**
 * 货位列表Mapper接口
 *
 * @author jia
 * @date 2022-12-06
 */
public interface LocationMapper
{
    /**
     * 查询货位列表
     *
     * @param locationId 货位列表主键
     * @return 货位列表
     */
    public Location selectLocationByLocationId(Integer locationId);

    /**
     * 查询货位列表列表
     *
     * @param location 货位列表
     * @return 货位列表集合
     */
    public List<Location> selectLocationList(Location location);

    /**
     * 新增货位列表
     *
     * @param location 货位列表
     * @return 结果
     */
    public int insertLocation(Location location);

    /**
     * 修改货位列表
     *
     * @param location 货位列表
     * @return 结果
     */
    public int updateLocation(Location location);

    /**
     * 删除货位列表
     *
     * @param locationId 货位列表主键
     * @return 结果
     */
    public int deleteLocationByLocationId(Integer locationId);

    /**
     * 批量删除货位列表
     *
     * @param locationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLocationByLocationIds(Integer[] locationIds);
}
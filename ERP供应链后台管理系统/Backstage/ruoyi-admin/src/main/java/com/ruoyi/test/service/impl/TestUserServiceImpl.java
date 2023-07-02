package com.ruoyi.test.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.TestUserMapper;
import com.ruoyi.test.domain.TestUser;
import com.ruoyi.test.service.ITestUserService;

/**
 * 测试用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-24
 */
@Service
public class TestUserServiceImpl implements ITestUserService 
{
    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 查询测试用户
     * 
     * @param id 测试用户主键
     * @return 测试用户
     */
    @Override
    public TestUser selectTestUserById(Long id)
    {
        return testUserMapper.selectTestUserById(id);
    }

    /**
     * 查询测试用户列表
     * 
     * @param testUser 测试用户
     * @return 测试用户
     */
    @Override
    public List<TestUser> selectTestUserList(TestUser testUser)
    {
        return testUserMapper.selectTestUserList(testUser);
    }

    /**
     * 新增测试用户
     * 
     * @param testUser 测试用户
     * @return 结果
     */
    @Override
    public int insertTestUser(TestUser testUser)
    {
        testUser.setCreateTime(DateUtils.getNowDate());
        return testUserMapper.insertTestUser(testUser);
    }

    /**
     * 修改测试用户
     * 
     * @param testUser 测试用户
     * @return 结果
     */
    @Override
    public int updateTestUser(TestUser testUser)
    {
        testUser.setUpdateTime(DateUtils.getNowDate());
        return testUserMapper.updateTestUser(testUser);
    }

    /**
     * 批量删除测试用户
     * 
     * @param ids 需要删除的测试用户主键
     * @return 结果
     */
    @Override
    public int deleteTestUserByIds(Long[] ids)
    {
        return testUserMapper.deleteTestUserByIds(ids);
    }

    /**
     * 删除测试用户信息
     * 
     * @param id 测试用户主键
     * @return 结果
     */
    @Override
    public int deleteTestUserById(Long id)
    {
        return testUserMapper.deleteTestUserById(id);
    }
}

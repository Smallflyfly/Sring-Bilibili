package com.fangpf.service;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 09:57
 */
public interface AccountService {

    /**
     * @description:
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * @description:
     * 模拟更新账户
     */
    void updateAccount(int i);

    /**
     * @description:
     * 删除账户
     */
    int deleteAccount();
}

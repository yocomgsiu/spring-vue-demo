package com.sjzHistory.service;

import com.sjzHistory.entity.Statistics;
import com.sjzHistory.entity.User;

public interface IStatisticsService {
    /**
     * 保存统计记录
     * @param Statistics
     * @return 保存成功将统计记录返回，否则返回null
     */
    User saveStatistics(Statistics statistics);

    
    /**
     * 按id查找
     * @param id
     * @return 注册成功将用户信息返回，否则返回null
     */
	User findStatisticsById(long id);

}

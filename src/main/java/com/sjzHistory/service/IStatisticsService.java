package com.sjzHistory.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sjzHistory.entity.Statistics;
import com.sjzHistory.entity.User;

public interface IStatisticsService {
    /**
     * 保存统计记录
     * @param Statistics
     * @return 保存成功将统计记录返回，否则返回null
     */
	Statistics saveStatistics(Statistics statistics);

    
    /**
     * 查User总数
     */
    long countUsers();

    /**
	 * 查Article总数
	 */
    long countArticles();

	/**
	 * 查所有统计Statistics
	 */
	Page<Statistics> findAllStatistics(Pageable pageable);
}

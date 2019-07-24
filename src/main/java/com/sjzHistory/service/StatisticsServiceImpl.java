package com.sjzHistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sjzHistory.entity.Statistics;
import com.sjzHistory.entity.User;
import com.sjzHistory.repository.StatisticsRepository;

@Service("StatisticsService")
public class StatisticsServiceImpl implements IStatisticsService {
	@Autowired
	StatisticsRepository statisticsRepository;

	/**
	 * 保存统计Statistics
	 * 没有id，程序会自动加；有不重复id，id会自动增加（自行设置无效）；id重复则更新。即saveOrUpdate
	 */
	public Statistics saveStatistics(Statistics statistics) {
		return statisticsRepository.saveAndFlush(statistics);
	}

	/**
	 * 查所有统计Statistics
	 */
	public Page<Statistics> findAllStatistics(Pageable pageable) {
		return statisticsRepository.findAll(pageable);
	}

	/**
	 * 查User总数
	 */
	@Override
	public long countUsers() {
		return statisticsRepository.countUsers();
	}

	/**
	 * 查Article总数
	 */
	@Override
	public long countArticles() {
		return statisticsRepository.countArticles();
	}

}

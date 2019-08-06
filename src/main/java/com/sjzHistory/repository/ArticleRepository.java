package com.sjzHistory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sjzHistory.entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
	

	/**
	 * 查寻文章
	 */
	@Query(value = "select a from Article a where a.eventTime <= timeKey "
			+ "and (a.title like concat('%',titleKey,'%') or a.content like concat('%',contentKey,'%'))"
			+ "and a.isDeleted != true")
	Page<Article> findAll(@Param("timeKey") long timeKey,@Param("titleKey") String titleKey, @Param("contentKey") String contentKey, Pageable pageable);
	
	/**
	 * 保存文章
	 */
	Article saveAndFlush(Article article);

}

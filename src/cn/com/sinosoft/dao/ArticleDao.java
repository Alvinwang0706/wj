package cn.com.sinosoft.dao;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.bean.Pager;
import cn.com.sinosoft.entity.Article;
import cn.com.sinosoft.entity.ArticleCategory;
import cn.com.sinosoft.entity.Channel;


/**
 * Dao接口 - 文章
 * ============================================================================
 *  
 *
 *  
 *
 *  
 *
 * KEY:SINOSOFT19BD2F9CE6FB7DC862A8038D9481F222
 * ============================================================================
 */

public interface ArticleDao extends BaseDao<Article, String> {

	/**
	 * 根据ArticleCategory对象，获取此分类下的所有文章（只包含isPublication=true的对象，包含子分类文章）
	 * 
	 * @param articleCategory
	 *            文章分类
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(ArticleCategory articleCategory);
	
	/**
	 * 根据起始结果数、最大结果数，获取所有文章（只包含isPublication=true的对象）
	 * 
	 * @param firstResult
	 *            起始结果数
	 *            
	 * @param maxResults
	 *            最大结果数
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(int firstResult, int maxResults);
	
	/**
	 * 根据ArticleCategory对象、起始结果数、最大结果数，获取此分类下的所有文章（只包含isPublication=true的对象，包含子分类文章）
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param firstResult
	 *            起始结果数
	 *            
	 * @param maxResults
	 *            最大结果数
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(ArticleCategory articleCategory, int firstResult, int maxResults);
	

	/**
	 * 根据ArticleCategory对象Channel对象、起始结果数、最大结果数，获取此分类下的所有文章（只包含isPublication=true的对象，包含子分类文章）
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param firstResult
	 *            起始结果数
	 *            
	 * @param maxResults
	 *            最大结果数
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(Channel channel,ArticleCategory articleCategory, int firstResult, int maxResults);
	
	/**
	 * 根据起始日期、结束日期、起始结果数、最大结果数，获取文章集合（只包含isPublication=true的对象）
	 * 
	 * @param beginDate
	 *            起始日期，为null则不限制起始日期
	 *            
	 * @param endDate
	 *            结束日期，为null则不限制结束日期
	 *            
	 * @param firstResult
	 *            起始结果数
	 *            
	 * @param maxResults
	 *            最大结果数
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(Date beginDate, Date endDate, int firstResult, int maxResults);
	/**
	 * 根据Channel对象、起始日期、结束日期、起始结果数、最大结果数，获取文章集合（只包含isPublication=true的对象）
	 * 
	 * @param beginDate
	 *            起始日期，为null则不限制起始日期
	 *            
	 * @param endDate
	 *            结束日期，为null则不限制结束日期
	 *            
	 * @param firstResult
	 *            起始结果数
	 *            
	 * @param maxResults
	 *            最大结果数
	 * 
	 * @return 此分类下的所有文章集合
	 */
	public List<Article> getArticleList(Channel channel,Date beginDate, Date endDate, int firstResult, int maxResults);
	
	/**
	 * 根据ArticleCategory和Pager对象，获取此分类下的文章分页对象（只包含isPublication=true的对象，包含子分类文章）
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param pager
	 *            分页对象
	 * 
	 * @return Pager
	 */
	public Pager getArticlePager(ArticleCategory articleCategory, Pager pager);
	/**
	 * 根据ArticleCategory、Channel对象和Pager对象，获取此分类下的文章分页对象（只包含isPublication=true的对象，包含子分类文章）
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param pager
	 *            分页对象
	 * 
	 * @return Pager
	 */
	public Pager getArticlePager(ArticleCategory articleCategory,Channel channel, Pager pager);
	
	
	/**
	 * 根据最大返回数获取所有推荐文章(只包含isPublication=true的对象，不限分类)
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 所有推荐文章集合
	 */
	public List<Article> getRecommendArticleList(int maxResults);

	/**
	 * 根据ArticleCategory对象和最大返回数获取此分类下的所有推荐文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的所有推荐文章集合
	 */
	public List<Article> getRecommendArticleList(ArticleCategory articleCategory, int maxResults);
	/**
	 * 根据ArticleCategory对象、Channel对象和最大返回数获取此分类下的所有推荐文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 *            
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的所有推荐文章集合
	 */
	public List<Article> getRecommendArticleList(ArticleCategory articleCategory,Channel channel, int maxResults);
	
	/**
	 * 根据最大返回数获取所有热点文章(只包含isPublication=true的对象，不限分类)
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 所有热点文章集合
	 */
	public List<Article> getHotArticleList(int maxResults);

	/**
	 * 根据ArticleCategory对象和最大返回数获取此分类下的所有热点文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的所有热点文章集合
	 */
	public List<Article> getHotArticleList(ArticleCategory articleCategory, int maxResults);
	/**
	 * 根据ArticleCategory对象、Channel对象和最大返回数获取此分类下的所有热点文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的所有热点文章集合
	 */
	public List<Article> getHotArticleList(ArticleCategory articleCategory, Channel channel,int maxResults);
	
	/**
	 * 根据最大返回数获取最新文章(只包含isPublication=true的对象，不限分类)
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 最新文章集合
	 */
	public List<Article> getNewArticleList(int maxResults);

	/**
	 * 根据ArticleCategory对象和最大返回数获取此分类下的最新文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的最新文章集合
	 */
	public List<Article> getNewArticleList(ArticleCategory articleCategory, int maxResults);
	/**
	 * 根据ArticleCategory对象、Channel对象和最大返回数获取此分类下的最新文章(只包含isPublication=true的对象，包含子分类文章)
	 * 
	 * @param articleCategory
	 *            文章分类
	 * 
	 * @param maxResults
	 *            最大返回数
	 * 
	 * @return 此分类下的最新文章集合
	 */
	public List<Article> getNewArticleList(ArticleCategory articleCategory,Channel channel, int maxResults);

	public List<Article> getHomeArticleList(ArticleCategory articleCategory);

	public List<Article> getArticleTreeList();

	public List<Article> getAllZj();

	public List<Article> getAllSp();

}

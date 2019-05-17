package cn.crawlerTweet.entity;

/**
 * 本类为采集微博规则类
 * 
 * @author 丁丁
 *
 */
public class WebSite {

	private int id; // 编号
	private String crawerUrl; // 要打开的网址

	private String clickAccountNumberRule; // 点击账号规则
	private String clickPasswordRule; // 点击密码规则
	private String clickRegisterRule; // 点击登录规则

	private String searchInputRule; // 搜索框规则
	private String clickSearchRule; // 点击搜索规则

	private String clickLookPersonRule; // 点击找人规则
	private String cssGetPersonUrlRule; // css获取查询博主url规则
	private String xpathGetPersonUrlRule;// xpath获取查询博主url规则

	private String clickAllTweetRule; // 点击全部微博规则
	private String bloggerNameRule; // 博主名称规则
	private String bloggerJobRule; // 博主工作规则
	private String bloggerAttentionNumberRule; // 博主关注数量规则
	private String bloggerFansNumberRule; // 博主粉丝数量规则
	private String bloggerTweetNumber; // 博主微博数量规则
	private String tweetModuleRule; // 微博模块规则
	private String tweetClickFullTitleRule; // 微博点击全文规则
	private String tweetTitleRule; // 微博标题规则
	private String tweetTimeRule; // 微博发出时间规则
	private String tweetImageUrlRule; // 微博图片规则
	private String tweetVideoUrlRule; // 微博视频规则
	private String tweetTranspondNumberRule; // 微博转发数规则
	private String tweetCommentNumberRule; // 微博评论数量规则
	private String tweetLikeNumberRule; // 微博点赞规则
	private String tweetIVPath; // 微博图片视频存放位置
	private String tweetNextRule; // 博主微博下一页规则

	private String clickArticleRule; // 点击文章规则
	private String getArticleUrlRule; // 获取文章规则
	private String nextArticleRule;// 点击文章下一页规则
	private String articleTitleRule; // 文章标题规则
	private String articleBloggerRule; //文章博主规则
	private String articleAuthorRule;// 文章作者规则
	private String articleTimeRule; // 文章发布时间规则
	private String articleSourceUrlRule; // 文章源网址规则
	private String articleReadNumberRule; // 文章阅读数规则
	private String articleContenrRule; // 文章内容规则
	private String articleFileName; // 文章文件名称
	private String articlePath;		// 文章保存位置
	
	private String clickVideoRule; // 点击视频规则
	private String videoModuleRule; // 获取video模块规则
	private String videoClickFullTitleRule; // 点击视频名称点开全文规则
	private String videoTitleRule; // 获取视频标题规则
	private String videoImageUrlRule; // 获取视频图片url规则
	private String videoUrlRule; // 获取视频链接规则
	private String videoTranspondNumberRrule; // 视频转发数量规则
	private String videoCommentNumberRrule; // 视频评论数量规则
	private String videoLikeNumberRrule; // 视频点赞数量规则
	private String videoPath; // 视频存放位置
	private String nextVideoRule; // 点击视频下一页规则

	private String imageRule; // 点击图片规则
	private String getImageRule; // 获取图片规则

	
	private String clickTopicRule; // 点击话题规则
	private String topicUrlRule; // 获取话题url规则
	private String topicTitleRule; //话题名称规则
	private String topicReadNumberRule; //话题阅读数规则
	private String topicDiscussNumbaerRule; //话题讨论数规则
	private String topicLeadRule; //话题导语规则
	private String topicTweetRule; // 话题微博规则
	private String topicTweetBloggerRule; //主题微博博主规则
	private String clickFullTopicTitleRule; //点击话题题微博标题全文规则
	private String topictweetTitleRule; // 话题微博标题规则
	private String topicTweetTimeRule; // 话题微博时间规则
	private String topicTweetVideoUrlRule; // 话题微博视频url链接
	private String topicTweetImageUrlRule; //话题微博图片规则
	private String topicTranspondNumberRule; //话题微博转发数规则
	private String topicCommentNumberRule; //话题微博评论数规则
	private String topicLikeNumberRule; //主题微博点赞数 	
	private String topicTweetIVPath; //主题微博视频图片存放位置
	private String nextTopicRule;// 话题下一页规则
	
	private int pagenumber; // 采集页数

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrawerUrl() {
		return crawerUrl;
	}

	public void setCrawerUrl(String crawerUrl) {
		this.crawerUrl = crawerUrl;
	}

	public String getTopicTweetBloggerRule() {
		return topicTweetBloggerRule;
	}

	public void setTopicTweetBloggerRule(String topicTweetBloggerRule) {
		this.topicTweetBloggerRule = topicTweetBloggerRule;
	}

	public String getClickAccountNumberRule() {
		return clickAccountNumberRule;
	}

	public void setClickAccountNumberRule(String clickAccountNumberRule) {
		this.clickAccountNumberRule = clickAccountNumberRule;
	}

	public String getClickPasswordRule() {
		return clickPasswordRule;
	}

	public void setClickPasswordRule(String clickPasswordRule) {
		this.clickPasswordRule = clickPasswordRule;
	}

	public String getClickRegisterRule() {
		return clickRegisterRule;
	}

	public void setClickRegisterRule(String clickRegisterRule) {
		this.clickRegisterRule = clickRegisterRule;
	}

	public String getSearchInputRule() {
		return searchInputRule;
	}

	public void setSearchInputRule(String searchInputRule) {
		this.searchInputRule = searchInputRule;
	}

	public String getClickSearchRule() {
		return clickSearchRule;
	}

	public void setClickSearchRule(String clickSearchRule) {
		this.clickSearchRule = clickSearchRule;
	}

	public String getClickLookPersonRule() {
		return clickLookPersonRule;
	}

	public void setClickLookPersonRule(String clickLookPersonRule) {
		this.clickLookPersonRule = clickLookPersonRule;
	}

	public String getCssGetPersonUrlRule() {
		return cssGetPersonUrlRule;
	}

	public String getTopicTweetRule() {
		return topicTweetRule;
	}

	public void setTopicTweetRule(String topicTweetRule) {
		this.topicTweetRule = topicTweetRule;
	}

	public void setCssGetPersonUrlRule(String cssGetPersonUrlRule) {
		this.cssGetPersonUrlRule = cssGetPersonUrlRule;
	}

	public String getXpathGetPersonUrlRule() {
		return xpathGetPersonUrlRule;
	}

	public void setXpathGetPersonUrlRule(String xpathGetPersonUrlRule) {
		this.xpathGetPersonUrlRule = xpathGetPersonUrlRule;
	}

	public String getClickAllTweetRule() {
		return clickAllTweetRule;
	}

	public void setClickAllTweetRule(String clickAllTweetRule) {
		this.clickAllTweetRule = clickAllTweetRule;
	}

	public String getBloggerNameRule() {
		return bloggerNameRule;
	}

	public void setBloggerNameRule(String bloggerNameRule) {
		this.bloggerNameRule = bloggerNameRule;
	}

	public String getBloggerJobRule() {
		return bloggerJobRule;
	}

	public void setBloggerJobRule(String bloggerJobRule) {
		this.bloggerJobRule = bloggerJobRule;
	}

	public String getBloggerAttentionNumberRule() {
		return bloggerAttentionNumberRule;
	}

	public void setBloggerAttentionNumberRule(String bloggerAttentionNumberRule) {
		this.bloggerAttentionNumberRule = bloggerAttentionNumberRule;
	}

	public String getBloggerFansNumberRule() {
		return bloggerFansNumberRule;
	}

	public void setBloggerFansNumberRule(String bloggerFansNumberRule) {
		this.bloggerFansNumberRule = bloggerFansNumberRule;
	}

	public String getBloggerTweetNumber() {
		return bloggerTweetNumber;
	}

	public void setBloggerTweetNumber(String bloggerTweetNumber) {
		this.bloggerTweetNumber = bloggerTweetNumber;
	}

	public String getTweetModuleRule() {
		return tweetModuleRule;
	}

	public void setTweetModuleRule(String tweetModuleRule) {
		this.tweetModuleRule = tweetModuleRule;
	}

	public String getTweetClickFullTitleRule() {
		return tweetClickFullTitleRule;
	}

	public void setTweetClickFullTitleRule(String tweetClickFullTitleRule) {
		this.tweetClickFullTitleRule = tweetClickFullTitleRule;
	}

	public String getTweetTitleRule() {
		return tweetTitleRule;
	}

	public void setTweetTitleRule(String tweetTitleRule) {
		this.tweetTitleRule = tweetTitleRule;
	}

	public String getTweetTimeRule() {
		return tweetTimeRule;
	}

	public void setTweetTimeRule(String tweetTimeRule) {
		this.tweetTimeRule = tweetTimeRule;
	}

	public String getTweetImageUrlRule() {
		return tweetImageUrlRule;
	}

	public void setTweetImageUrlRule(String tweetImageUrlRule) {
		this.tweetImageUrlRule = tweetImageUrlRule;
	}

	public String getTweetVideoUrlRule() {
		return tweetVideoUrlRule;
	}

	public void setTweetVideoUrlRule(String tweetVideoUrlRule) {
		this.tweetVideoUrlRule = tweetVideoUrlRule;
	}

	public String getTweetTranspondNumberRule() {
		return tweetTranspondNumberRule;
	}

	public void setTweetTranspondNumberRule(String tweetTranspondNumberRule) {
		this.tweetTranspondNumberRule = tweetTranspondNumberRule;
	}

	public String getTweetCommentNumberRule() {
		return tweetCommentNumberRule;
	}

	public void setTweetCommentNumberRule(String tweetCommentNumberRule) {
		this.tweetCommentNumberRule = tweetCommentNumberRule;
	}

	public String getTweetLikeNumberRule() {
		return tweetLikeNumberRule;
	}

	public void setTweetLikeNumberRule(String tweetLikeNumberRule) {
		this.tweetLikeNumberRule = tweetLikeNumberRule;
	}

	public String getTweetIVPath() {
		return tweetIVPath;
	}

	public void setTweetIVPath(String tweetIVPath) {
		this.tweetIVPath = tweetIVPath;
	}

	public String getTweetNextRule() {
		return tweetNextRule;
	}

	public void setTweetNextRule(String tweetNextRule) {
		this.tweetNextRule = tweetNextRule;
	}

	public String getClickArticleRule() {
		return clickArticleRule;
	}

	public void setClickArticleRule(String clickArticleRule) {
		this.clickArticleRule = clickArticleRule;
	}

	public String getGetArticleUrlRule() {
		return getArticleUrlRule;
	}

	public void setGetArticleUrlRule(String getArticleUrlRule) {
		this.getArticleUrlRule = getArticleUrlRule;
	}

	public String getNextArticleRule() {
		return nextArticleRule;
	}

	public void setNextArticleRule(String nextArticleRule) {
		this.nextArticleRule = nextArticleRule;
	}

	public String getArticleTitleRule() {
		return articleTitleRule;
	}

	public void setArticleTitleRule(String articleTitleRule) {
		this.articleTitleRule = articleTitleRule;
	}

	public String getArticleBloggerRule() {
		return articleBloggerRule;
	}

	public void setArticleBloggerRule(String articleBloggerRule) {
		this.articleBloggerRule = articleBloggerRule;
	}

	public String getArticleAuthorRule() {
		return articleAuthorRule;
	}

	public void setArticleAuthorRule(String articleAuthorRule) {
		this.articleAuthorRule = articleAuthorRule;
	}

	public String getArticleTimeRule() {
		return articleTimeRule;
	}

	public void setArticleTimeRule(String articleTimeRule) {
		this.articleTimeRule = articleTimeRule;
	}

	public String getArticleSourceUrlRule() {
		return articleSourceUrlRule;
	}

	public void setArticleSourceUrlRule(String articleSourceUrlRule) {
		this.articleSourceUrlRule = articleSourceUrlRule;
	}

	public String getArticleReadNumberRule() {
		return articleReadNumberRule;
	}

	public void setArticleReadNumberRule(String articleReadNumberRule) {
		this.articleReadNumberRule = articleReadNumberRule;
	}

	public String getArticleContenrRule() {
		return articleContenrRule;
	}

	public void setArticleContenrRule(String articleContenrRule) {
		this.articleContenrRule = articleContenrRule;
	}

	public String getArticleFileName() {
		return articleFileName;
	}

	public void setArticleFileName(String articleFileName) {
		this.articleFileName = articleFileName;
	}

	public String getArticlePath() {
		return articlePath;
	}

	public void setArticlePath(String articlePath) {
		this.articlePath = articlePath;
	}

	public String getClickVideoRule() {
		return clickVideoRule;
	}

	public void setClickVideoRule(String clickVideoRule) {
		this.clickVideoRule = clickVideoRule;
	}

	public String getVideoModuleRule() {
		return videoModuleRule;
	}

	public void setVideoModuleRule(String videoModuleRule) {
		this.videoModuleRule = videoModuleRule;
	}

	public String getVideoClickFullTitleRule() {
		return videoClickFullTitleRule;
	}

	public void setVideoClickFullTitleRule(String videoClickFullTitleRule) {
		this.videoClickFullTitleRule = videoClickFullTitleRule;
	}

	public String getVideoTitleRule() {
		return videoTitleRule;
	}

	public void setVideoTitleRule(String videoTitleRule) {
		this.videoTitleRule = videoTitleRule;
	}

	public String getVideoImageUrlRule() {
		return videoImageUrlRule;
	}

	public void setVideoImageUrlRule(String videoImageUrlRule) {
		this.videoImageUrlRule = videoImageUrlRule;
	}

	public String getVideoUrlRule() {
		return videoUrlRule;
	}

	public void setVideoUrlRule(String videoUrlRule) {
		this.videoUrlRule = videoUrlRule;
	}

	public String getVideoTranspondNumberRrule() {
		return videoTranspondNumberRrule;
	}

	public void setVideoTranspondNumberRrule(String videoTranspondNumberRrule) {
		this.videoTranspondNumberRrule = videoTranspondNumberRrule;
	}

	public String getVideoCommentNumberRrule() {
		return videoCommentNumberRrule;
	}

	public void setVideoCommentNumberRrule(String videoCommentNumberRrule) {
		this.videoCommentNumberRrule = videoCommentNumberRrule;
	}

	public String getVideoLikeNumberRrule() {
		return videoLikeNumberRrule;
	}

	public void setVideoLikeNumberRrule(String videoLikeNumberRrule) {
		this.videoLikeNumberRrule = videoLikeNumberRrule;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getNextVideoRule() {
		return nextVideoRule;
	}

	public void setNextVideoRule(String nextVideoRule) {
		this.nextVideoRule = nextVideoRule;
	}

	public String getImageRule() {
		return imageRule;
	}

	public void setImageRule(String imageRule) {
		this.imageRule = imageRule;
	}

	public String getGetImageRule() {
		return getImageRule;
	}

	public void setGetImageRule(String getImageRule) {
		this.getImageRule = getImageRule;
	}

	public String getClickTopicRule() {
		return clickTopicRule;
	}

	public void setClickTopicRule(String clickTopicRule) {
		this.clickTopicRule = clickTopicRule;
	}

	public String getTopicUrlRule() {
		return topicUrlRule;
	}

	public void setTopicUrlRule(String topicUrlRule) {
		this.topicUrlRule = topicUrlRule;
	}

	public String getTopicTitleRule() {
		return topicTitleRule;
	}

	public void setTopicTitleRule(String topicTitleRule) {
		this.topicTitleRule = topicTitleRule;
	}

	public String getTopicReadNumberRule() {
		return topicReadNumberRule;
	}

	public void setTopicReadNumberRule(String topicReadNumberRule) {
		this.topicReadNumberRule = topicReadNumberRule;
	}

	public String getTopicDiscussNumbaerRule() {
		return topicDiscussNumbaerRule;
	}

	public void setTopicDiscussNumbaerRule(String topicDiscussNumbaerRule) {
		this.topicDiscussNumbaerRule = topicDiscussNumbaerRule;
	}

	public String getTopicLeadRule() {
		return topicLeadRule;
	}

	public void setTopicLeadRule(String topicLeadRule) {
		this.topicLeadRule = topicLeadRule;
	}

	public String getClickFullTopicTitleRule() {
		return clickFullTopicTitleRule;
	}

	public void setClickFullTopicTitleRule(String clickFullTopicTitleRule) {
		this.clickFullTopicTitleRule = clickFullTopicTitleRule;
	}

	public String getTopictweetTitleRule() {
		return topictweetTitleRule;
	}

	public void setTopictweetTitleRule(String topictweetTitleRule) {
		this.topictweetTitleRule = topictweetTitleRule;
	}

	public String getTopicTweetTimeRule() {
		return topicTweetTimeRule;
	}

	public void setTopicTweetTimeRule(String topicTweetTimeRule) {
		this.topicTweetTimeRule = topicTweetTimeRule;
	}

	public String getTopicTweetVideoUrlRule() {
		return topicTweetVideoUrlRule;
	}

	public void setTopicTweetVideoUrlRule(String topicTweetVideoUrlRule) {
		this.topicTweetVideoUrlRule = topicTweetVideoUrlRule;
	}

	public String getTopicTweetImageUrlRule() {
		return topicTweetImageUrlRule;
	}

	public void setTopicTweetImageUrlRule(String topicTweetImageUrlRule) {
		this.topicTweetImageUrlRule = topicTweetImageUrlRule;
	}

	public String getTopicTranspondNumberRule() {
		return topicTranspondNumberRule;
	}

	public void setTopicTranspondNumberRule(String topicTranspondNumberRule) {
		this.topicTranspondNumberRule = topicTranspondNumberRule;
	}

	public String getTopicCommentNumberRule() {
		return topicCommentNumberRule;
	}

	public void setTopicCommentNumberRule(String topicCommentNumberRule) {
		this.topicCommentNumberRule = topicCommentNumberRule;
	}

	public String getTopicLikeNumberRule() {
		return topicLikeNumberRule;
	}

	public void setTopicLikeNumber(String topicLikeNumberRule) {
		this.topicLikeNumberRule = topicLikeNumberRule;
	}

	public String getTopicTweetIVPath() {
		return topicTweetIVPath;
	}

	public void setTopicTweetIVPath(String topicTweetIVPath) {
		this.topicTweetIVPath = topicTweetIVPath;
	}

	public String getNextTopicRule() {
		return nextTopicRule;
	}

	public void setNextTopicRule(String nextTopicRule) {
		this.nextTopicRule = nextTopicRule;
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
}

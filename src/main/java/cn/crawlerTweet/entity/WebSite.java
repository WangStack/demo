package cn.crawlerTweet.entity;

/**
 * ����Ϊ�ɼ�΢��������
 * 
 * @author ����
 *
 */
public class WebSite {

	private int id; // ���
	private String crawerUrl; // Ҫ�򿪵���ַ

	private String clickAccountNumberRule; // ����˺Ź���
	private String clickPasswordRule; // ����������
	private String clickRegisterRule; // �����¼����

	private String searchInputRule; // ���������
	private String clickSearchRule; // �����������

	private String clickLookPersonRule; // ������˹���
	private String cssGetPersonUrlRule; // css��ȡ��ѯ����url����
	private String xpathGetPersonUrlRule;// xpath��ȡ��ѯ����url����

	private String clickAllTweetRule; // ���ȫ��΢������
	private String bloggerNameRule; // �������ƹ���
	private String bloggerJobRule; // ������������
	private String bloggerAttentionNumberRule; // ������ע��������
	private String bloggerFansNumberRule; // ������˿��������
	private String bloggerTweetNumber; // ����΢����������
	private String tweetModuleRule; // ΢��ģ�����
	private String tweetClickFullTitleRule; // ΢�����ȫ�Ĺ���
	private String tweetTitleRule; // ΢���������
	private String tweetTimeRule; // ΢������ʱ�����
	private String tweetImageUrlRule; // ΢��ͼƬ����
	private String tweetVideoUrlRule; // ΢����Ƶ����
	private String tweetTranspondNumberRule; // ΢��ת��������
	private String tweetCommentNumberRule; // ΢��������������
	private String tweetLikeNumberRule; // ΢�����޹���
	private String tweetIVPath; // ΢��ͼƬ��Ƶ���λ��
	private String tweetNextRule; // ����΢����һҳ����

	private String clickArticleRule; // ������¹���
	private String getArticleUrlRule; // ��ȡ���¹���
	private String nextArticleRule;// ���������һҳ����
	private String articleTitleRule; // ���±������
	private String articleBloggerRule; //���²�������
	private String articleAuthorRule;// �������߹���
	private String articleTimeRule; // ���·���ʱ�����
	private String articleSourceUrlRule; // ����Դ��ַ����
	private String articleReadNumberRule; // �����Ķ�������
	private String articleContenrRule; // �������ݹ���
	private String articleFileName; // �����ļ�����
	private String articlePath;		// ���±���λ��
	
	private String clickVideoRule; // �����Ƶ����
	private String videoModuleRule; // ��ȡvideoģ�����
	private String videoClickFullTitleRule; // �����Ƶ���Ƶ㿪ȫ�Ĺ���
	private String videoTitleRule; // ��ȡ��Ƶ�������
	private String videoImageUrlRule; // ��ȡ��ƵͼƬurl����
	private String videoUrlRule; // ��ȡ��Ƶ���ӹ���
	private String videoTranspondNumberRrule; // ��Ƶת����������
	private String videoCommentNumberRrule; // ��Ƶ������������
	private String videoLikeNumberRrule; // ��Ƶ������������
	private String videoPath; // ��Ƶ���λ��
	private String nextVideoRule; // �����Ƶ��һҳ����

	private String imageRule; // ���ͼƬ����
	private String getImageRule; // ��ȡͼƬ����

	
	private String clickTopicRule; // ����������
	private String topicUrlRule; // ��ȡ����url����
	private String topicTitleRule; //�������ƹ���
	private String topicReadNumberRule; //�����Ķ�������
	private String topicDiscussNumbaerRule; //��������������
	private String topicLeadRule; //���⵼�����
	private String topicTweetRule; // ����΢������
	private String topicTweetBloggerRule; //����΢����������
	private String clickFullTopicTitleRule; //���������΢������ȫ�Ĺ���
	private String topictweetTitleRule; // ����΢���������
	private String topicTweetTimeRule; // ����΢��ʱ�����
	private String topicTweetVideoUrlRule; // ����΢����Ƶurl����
	private String topicTweetImageUrlRule; //����΢��ͼƬ����
	private String topicTranspondNumberRule; //����΢��ת��������
	private String topicCommentNumberRule; //����΢������������
	private String topicLikeNumberRule; //����΢�������� 	
	private String topicTweetIVPath; //����΢����ƵͼƬ���λ��
	private String nextTopicRule;// ������һҳ����
	
	private int pagenumber; // �ɼ�ҳ��

	
	
	
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

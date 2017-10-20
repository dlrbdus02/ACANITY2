package community.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Community implements Serializable {
	
	private String communityCategory;
	private int communityNo;
	private String communityName;
	private String communityClass;
	private String communityTime;
	private Date communityStartDate;
	private Date communityEndDate;
	private int communityLimit;
	private String communityImgUrl;
	private String communityContent;
	private String communityId;
	private int communityReadCount;
	private int communityJoinNo;
	private String communityJoinId;
	private Date communityJoinDate;
	private Date communityHistoryDate;
	private int communityHistoryNo;
	private String communityHistoryPlace;
	
	public Community() {
		super();
	}

	public Community(String communityCategory, int communityNo, String communityName, String communityClass,
			String communityTime, Date communityStartDate, Date communityEndDate, int communityLimit,
			String communityImgUrl, String communityContent, String communityId, int communityReadCount) {
		super();
		this.communityCategory = communityCategory;
		this.communityNo = communityNo;
		this.communityName = communityName;
		this.communityClass = communityClass;
		this.communityTime = communityTime;
		this.communityStartDate = communityStartDate;
		this.communityEndDate = communityEndDate;
		this.communityLimit = communityLimit;
		this.communityImgUrl = communityImgUrl;
		this.communityContent = communityContent;
		this.communityReadCount = communityReadCount;
		this.communityId = communityId;
	}

	public Community(int communityJoinNo, String communityJoinId, Date communityJoinDate) {
		super();
		this.communityJoinNo = communityJoinNo;
		this.communityJoinId = communityJoinId;
		this.communityJoinDate = communityJoinDate;
	}

	public Community(Date communityHistoryDate, int communityHistoryNo, 
			String communityHistoryPlace) {
		super();
		this.communityHistoryDate = communityHistoryDate;
		this.communityHistoryNo = communityHistoryNo;
		this.communityHistoryPlace = communityHistoryPlace;
	}

	public Community(String communityCategory, int communityNo, String communityName, String communityClass,
			String communityTime, Date communityStartDate, Date communityEndDate, int communityLimit,
			String communityImgUrl, String communityContent, String communityId, int communityReadCount, int communityJoinNo,
			String communityJoinId, Date communityJoinDate, Date communityHistoryDate, int communityHistoryNo, String communityHistoryPlace) {
		super();
		this.communityCategory = communityCategory;
		this.communityNo = communityNo;
		this.communityName = communityName;
		this.communityClass = communityClass;
		this.communityTime = communityTime;
		this.communityStartDate = communityStartDate;
		this.communityEndDate = communityEndDate;
		this.communityLimit = communityLimit;
		this.communityImgUrl = communityImgUrl;
		this.communityContent = communityContent;
		this.communityId = communityId;
		this.communityReadCount = communityReadCount;
		this.communityJoinNo = communityJoinNo;
		this.communityJoinId = communityJoinId;
		this.communityJoinDate = communityJoinDate;
		this.communityHistoryDate = communityHistoryDate;
		this.communityHistoryNo = communityHistoryNo;
		this.communityHistoryPlace = communityHistoryPlace;
	}

	public String getCommunityCategory() {
		return communityCategory;
	}

	public void setCommunityCategory(String communityCategory) {
		this.communityCategory = communityCategory;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityClass() {
		return communityClass;
	}

	public void setCommunityClass(String communityClass) {
		this.communityClass = communityClass;
	}

	public String getCommunityTime() {
		return communityTime;
	}

	public void setCommunityTime(String communityTime) {
		this.communityTime = communityTime;
	}

	public Date getCommunityStartDate() {
		return communityStartDate;
	}

	public void setCommunityStartDate(Date communityStartDate) {
		this.communityStartDate = communityStartDate;
	}

	public Date getCommunityEndDate() {
		return communityEndDate;
	}

	public void setCommunityEndDate(Date communityEndDate) {
		this.communityEndDate = communityEndDate;
	}

	public int getCommunityLimit() {
		return communityLimit;
	}

	public void setCommunityLimit(int communityLimit) {
		this.communityLimit = communityLimit;
	}

	public String getCommunityImgUrl() {
		return communityImgUrl;
	}

	public void setCommunityImgUrl(String communityImgUrl) {
		this.communityImgUrl = communityImgUrl;
	}

	public String getCommunityContent() {
		return communityContent;
	}

	public void setCommunityContent(String communityContent) {
		this.communityContent = communityContent;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public int getCommunityReadCount(){
		return communityReadCount;
	}
	
	public void setCommunityReadCount(int communityReadCount){
		this.communityReadCount = communityReadCount;
	}
	public int getCommunityJoinNo() {
		return communityJoinNo;
	}

	public void setCommunityJoinNo(int communityJoinNo) {
		this.communityJoinNo = communityJoinNo;
	}

	public String getCommunityJoinId() {
		return communityJoinId;
	}

	public void setCommunityJoinId(String communityJoinId) {
		this.communityJoinId = communityJoinId;
	}

	public Date getCommunityJoinDate() {
		return communityJoinDate;
	}

	public void setCommunityJoinDate(Date communityJoinDate) {
		this.communityJoinDate = communityJoinDate;
	}

	public Date getCommunityHistoryDate() {
		return communityHistoryDate;
	}

	public void setCommunityHistoryDate(Date communityHistoryDate) {
		this.communityHistoryDate = communityHistoryDate;
	}

	public int getCommunityHistoryNo() {
		return communityHistoryNo;
	}

	public void setCommunityHistoryNo(int communityHistoryNo) {
		this.communityHistoryNo = communityHistoryNo;
	}


	public String getCommunityHistoryPlace() {
		return communityHistoryPlace;
	}

	public void setCommunityHistoryPlace(String communityHistoryPlace) {
		this.communityHistoryPlace = communityHistoryPlace;
	}

	@Override
	public String toString() {
		return communityCategory + ", " + communityNo + ", " + communityName + ", " + communityClass + ", " + 
			   communityTime + ", " + communityStartDate + ", " + communityEndDate + ", " + 
			   communityLimit + ", " + communityImgUrl + ", " + communityContent + ", " + 
			   communityId + ", " + communityJoinNo + ", " + communityJoinId + ", " + communityJoinDate + ", " + 
			   communityHistoryDate + ", " + communityHistoryNo +  ", " + communityHistoryPlace;
	}
	
	

}

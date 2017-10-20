package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = 1111L;

	private String mId; // ���̵�
	private String mPwd; // ��й�ȣ
	private String mName; // �̸�
	private String mClass; // Ŭ���� (A, B, C, D, E, F)
	private String mTime; // ����Ÿ�� (����, ����)
	private String mTel; // ��ȭ��ȣ
	private String mEmail; // �̸���

	public Member() {
		super();
	}

	public Member(String mId, String mPwd, String mName, String mClass, String mTime, String mTel, String mEmail) {
		super();
		this.mId = mId;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mClass = mClass;
		this.mTime = mTime;
		this.mTel = mTel;
		this.mEmail = mEmail;
	}

	public Member(String mId, String mPwd, String mName, String mTel, String mEmail) {
		super();
		this.mId = mId;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mTel = mTel;
		this.mEmail = mEmail;
	}

	public Member(String mId, String mName, String mTel, String mEmail) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mTel = mTel;
		this.mEmail = mEmail;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmClass() {
		return mClass;
	}

	public void setmClass(String mClass) {
		this.mClass = mClass;
	}

	public String getmTime() {
		return mTime;
	}

	public void setmTime(String mTime) {
		this.mTime = mTime;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPwd=" + mPwd + ", mName=" + mName + ", mClass=" + mClass + ", mTime=" + mTime
				+ ", mTel=" + mTel + ", mEmail=" + mEmail + "]";
	}

}
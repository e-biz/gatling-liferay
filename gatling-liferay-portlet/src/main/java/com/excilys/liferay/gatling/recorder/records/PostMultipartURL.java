package com.excilys.liferay.gatling.recorder.records;

import com.excilys.liferay.gatling.service.FormParamLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

//TODO: Comment Me !

public class PostMultipartURL extends RecordURL{
	
	protected String formData;
	protected String formType;
	
	public PostMultipartURL(String requestURL, String params, String formData) {
		super("POST", requestURL, params);
		this.formData = formData;
		this.formType = "MULTIPART";
	}
	
	@Override
	protected void saveData(long primaryKey) throws SystemException {
		FormParamLocalServiceUtil.save(primaryKey, formData, formType);
	}

	@Override
	public String toString() {
		return "RecordURL [method=" + method + ", url=" + url + ", params="
				+ params + ", formType=" + formType + ", formData=" + formData + "]";
	}
	
	
}
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.RequestModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Request service. Represents a row in the &quot;StressTool_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.excilys.liferay.gatling.model.RequestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequestImpl
 * @see com.excilys.liferay.gatling.model.Request
 * @see com.excilys.liferay.gatling.model.RequestModel
 * @generated
 */
public class RequestModelImpl extends BaseModelImpl<Request>
	implements RequestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a request model instance should use the {@link com.excilys.liferay.gatling.model.Request} interface instead.
	 */
	public static final String TABLE_NAME = "StressTool_Request";
	public static final Object[][] TABLE_COLUMNS = {
			{ "request_id", Types.BIGINT },
			{ "scenario_id", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "url", Types.VARCHAR },
			{ "weight", Types.DOUBLE },
			{ "privatePage", Types.BOOLEAN },
			{ "parentLayoutId", Types.BIGINT },
			{ "layoutId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table StressTool_Request (request_id LONG not null primary key,scenario_id LONG,name VARCHAR(75) null,url VARCHAR(75) null,weight DOUBLE,privatePage BOOLEAN,parentLayoutId LONG,layoutId LONG)";
	public static final String TABLE_SQL_DROP = "drop table StressTool_Request";
	public static final String ORDER_BY_JPQL = " ORDER BY request.request_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY StressTool_Request.request_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.excilys.liferay.gatling.model.Request"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.excilys.liferay.gatling.model.Request"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.excilys.liferay.gatling.model.Request"),
			true);
	public static long SCENARIO_ID_COLUMN_BITMASK = 1L;
	public static long REQUEST_ID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.excilys.liferay.gatling.model.Request"));

	public RequestModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _request_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequest_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _request_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Request.class;
	}

	@Override
	public String getModelClassName() {
		return Request.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("request_id", getRequest_id());
		attributes.put("scenario_id", getScenario_id());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("weight", getWeight());
		attributes.put("privatePage", getPrivatePage());
		attributes.put("parentLayoutId", getParentLayoutId());
		attributes.put("layoutId", getLayoutId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long request_id = (Long)attributes.get("request_id");

		if (request_id != null) {
			setRequest_id(request_id);
		}

		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Boolean privatePage = (Boolean)attributes.get("privatePage");

		if (privatePage != null) {
			setPrivatePage(privatePage);
		}

		Long parentLayoutId = (Long)attributes.get("parentLayoutId");

		if (parentLayoutId != null) {
			setParentLayoutId(parentLayoutId);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}
	}

	@Override
	public long getRequest_id() {
		return _request_id;
	}

	@Override
	public void setRequest_id(long request_id) {
		_request_id = request_id;
	}

	@Override
	public long getScenario_id() {
		return _scenario_id;
	}

	@Override
	public void setScenario_id(long scenario_id) {
		_columnBitmask |= SCENARIO_ID_COLUMN_BITMASK;

		if (!_setOriginalScenario_id) {
			_setOriginalScenario_id = true;

			_originalScenario_id = _scenario_id;
		}

		_scenario_id = scenario_id;
	}

	public long getOriginalScenario_id() {
		return _originalScenario_id;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@Override
	public double getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(double weight) {
		_weight = weight;
	}

	@Override
	public boolean getPrivatePage() {
		return _privatePage;
	}

	@Override
	public boolean isPrivatePage() {
		return _privatePage;
	}

	@Override
	public void setPrivatePage(boolean privatePage) {
		_privatePage = privatePage;
	}

	@Override
	public long getParentLayoutId() {
		return _parentLayoutId;
	}

	@Override
	public void setParentLayoutId(long parentLayoutId) {
		_parentLayoutId = parentLayoutId;
	}

	@Override
	public long getLayoutId() {
		return _layoutId;
	}

	@Override
	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Request.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Request toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Request)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RequestImpl requestImpl = new RequestImpl();

		requestImpl.setRequest_id(getRequest_id());
		requestImpl.setScenario_id(getScenario_id());
		requestImpl.setName(getName());
		requestImpl.setUrl(getUrl());
		requestImpl.setWeight(getWeight());
		requestImpl.setPrivatePage(getPrivatePage());
		requestImpl.setParentLayoutId(getParentLayoutId());
		requestImpl.setLayoutId(getLayoutId());

		requestImpl.resetOriginalValues();

		return requestImpl;
	}

	@Override
	public int compareTo(Request request) {
		long primaryKey = request.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Request)) {
			return false;
		}

		Request request = (Request)obj;

		long primaryKey = request.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		RequestModelImpl requestModelImpl = this;

		requestModelImpl._originalScenario_id = requestModelImpl._scenario_id;

		requestModelImpl._setOriginalScenario_id = false;

		requestModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Request> toCacheModel() {
		RequestCacheModel requestCacheModel = new RequestCacheModel();

		requestCacheModel.request_id = getRequest_id();

		requestCacheModel.scenario_id = getScenario_id();

		requestCacheModel.name = getName();

		String name = requestCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			requestCacheModel.name = null;
		}

		requestCacheModel.url = getUrl();

		String url = requestCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			requestCacheModel.url = null;
		}

		requestCacheModel.weight = getWeight();

		requestCacheModel.privatePage = getPrivatePage();

		requestCacheModel.parentLayoutId = getParentLayoutId();

		requestCacheModel.layoutId = getLayoutId();

		return requestCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{request_id=");
		sb.append(getRequest_id());
		sb.append(", scenario_id=");
		sb.append(getScenario_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", privatePage=");
		sb.append(getPrivatePage());
		sb.append(", parentLayoutId=");
		sb.append(getParentLayoutId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.Request");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>request_id</column-name><column-value><![CDATA[");
		sb.append(getRequest_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scenario_id</column-name><column-value><![CDATA[");
		sb.append(getScenario_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privatePage</column-name><column-value><![CDATA[");
		sb.append(getPrivatePage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentLayoutId</column-name><column-value><![CDATA[");
		sb.append(getParentLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Request.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Request.class
		};
	private long _request_id;
	private long _scenario_id;
	private long _originalScenario_id;
	private boolean _setOriginalScenario_id;
	private String _name;
	private String _url;
	private double _weight;
	private boolean _privatePage;
	private long _parentLayoutId;
	private long _layoutId;
	private long _columnBitmask;
	private Request _escapedModel;
}
package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.SiteMapModel;

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
 * The base model implementation for the SiteMap service. Represents a row in the &quot;StressTool_SiteMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.excilys.liferay.gatling.model.SiteMapModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SiteMapImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapImpl
 * @see com.excilys.liferay.gatling.model.SiteMap
 * @see com.excilys.liferay.gatling.model.SiteMapModel
 * @generated
 */
public class SiteMapModelImpl extends BaseModelImpl<SiteMap>
    implements SiteMapModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a site map model instance should use the {@link com.excilys.liferay.gatling.model.SiteMap} interface instead.
     */
    public static final String TABLE_NAME = "StressTool_SiteMap";
    public static final Object[][] TABLE_COLUMNS = {
            { "siteMapId", Types.BIGINT },
            { "name", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table StressTool_SiteMap (siteMapId LONG not null primary key,name VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table StressTool_SiteMap";
    public static final String ORDER_BY_JPQL = " ORDER BY siteMap.siteMapId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY StressTool_SiteMap.siteMapId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.excilys.liferay.gatling.model.SiteMap"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.excilys.liferay.gatling.model.SiteMap"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.excilys.liferay.gatling.model.SiteMap"),
            true);
    public static long NAME_COLUMN_BITMASK = 1L;
    public static long SITEMAPID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.excilys.liferay.gatling.model.SiteMap"));
    private static ClassLoader _classLoader = SiteMap.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            SiteMap.class
        };
    private long _siteMapId;
    private String _name;
    private String _originalName;
    private long _columnBitmask;
    private SiteMap _escapedModel;

    public SiteMapModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _siteMapId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSiteMapId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _siteMapId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return SiteMap.class;
    }

    @Override
    public String getModelClassName() {
        return SiteMap.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("siteMapId", getSiteMapId());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long siteMapId = (Long) attributes.get("siteMapId");

        if (siteMapId != null) {
            setSiteMapId(siteMapId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getSiteMapId() {
        return _siteMapId;
    }

    @Override
    public void setSiteMapId(long siteMapId) {
        _siteMapId = siteMapId;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            SiteMap.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public SiteMap toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (SiteMap) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        SiteMapImpl siteMapImpl = new SiteMapImpl();

        siteMapImpl.setSiteMapId(getSiteMapId());
        siteMapImpl.setName(getName());

        siteMapImpl.resetOriginalValues();

        return siteMapImpl;
    }

    @Override
    public int compareTo(SiteMap siteMap) {
        long primaryKey = siteMap.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SiteMap)) {
            return false;
        }

        SiteMap siteMap = (SiteMap) obj;

        long primaryKey = siteMap.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        SiteMapModelImpl siteMapModelImpl = this;

        siteMapModelImpl._originalName = siteMapModelImpl._name;

        siteMapModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<SiteMap> toCacheModel() {
        SiteMapCacheModel siteMapCacheModel = new SiteMapCacheModel();

        siteMapCacheModel.siteMapId = getSiteMapId();

        siteMapCacheModel.name = getName();

        String name = siteMapCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            siteMapCacheModel.name = null;
        }

        return siteMapCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{siteMapId=");
        sb.append(getSiteMapId());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.SiteMap");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>siteMapId</column-name><column-value><![CDATA[");
        sb.append(getSiteMapId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

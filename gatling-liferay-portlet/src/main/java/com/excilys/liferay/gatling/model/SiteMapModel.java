package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SiteMap service. Represents a row in the &quot;StressTool_SiteMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.excilys.liferay.gatling.model.impl.SiteMapModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.excilys.liferay.gatling.model.impl.SiteMapImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMap
 * @see com.excilys.liferay.gatling.model.impl.SiteMapImpl
 * @see com.excilys.liferay.gatling.model.impl.SiteMapModelImpl
 * @generated
 */
public interface SiteMapModel extends BaseModel<SiteMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a site map model instance should use the {@link SiteMap} interface instead.
     */

    /**
     * Returns the primary key of this site map.
     *
     * @return the primary key of this site map
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this site map.
     *
     * @param primaryKey the primary key of this site map
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the site map ID of this site map.
     *
     * @return the site map ID of this site map
     */
    public long getSiteMapId();

    /**
     * Sets the site map ID of this site map.
     *
     * @param siteMapId the site map ID of this site map
     */
    public void setSiteMapId(long siteMapId);

    /**
     * Returns the name of this site map.
     *
     * @return the name of this site map
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this site map.
     *
     * @param name the name of this site map
     */
    public void setName(String name);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(SiteMap siteMap);

    @Override
    public int hashCode();

    @Override
    public CacheModel<SiteMap> toCacheModel();

    @Override
    public SiteMap toEscapedModel();

    @Override
    public SiteMap toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

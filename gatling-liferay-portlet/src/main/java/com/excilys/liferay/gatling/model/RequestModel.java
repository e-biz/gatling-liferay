package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Request service. Represents a row in the &quot;StressTool_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.excilys.liferay.gatling.model.impl.RequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Request
 * @see com.excilys.liferay.gatling.model.impl.RequestImpl
 * @see com.excilys.liferay.gatling.model.impl.RequestModelImpl
 * @generated
 */
public interface RequestModel extends BaseModel<Request> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a request model instance should use the {@link Request} interface instead.
     */

    /**
     * Returns the primary key of this request.
     *
     * @return the primary key of this request
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this request.
     *
     * @param primaryKey the primary key of this request
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the request_id of this request.
     *
     * @return the request_id of this request
     */
    public long getRequest_id();

    /**
     * Sets the request_id of this request.
     *
     * @param request_id the request_id of this request
     */
    public void setRequest_id(long request_id);

    /**
     * Returns the scenario_id of this request.
     *
     * @return the scenario_id of this request
     */
    public long getScenario_id();

    /**
     * Sets the scenario_id of this request.
     *
     * @param scenario_id the scenario_id of this request
     */
    public void setScenario_id(long scenario_id);

    /**
     * Returns the name of this request.
     *
     * @return the name of this request
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this request.
     *
     * @param name the name of this request
     */
    public void setName(String name);

    /**
     * Returns the url of this request.
     *
     * @return the url of this request
     */
    @AutoEscape
    public String getUrl();

    /**
     * Sets the url of this request.
     *
     * @param url the url of this request
     */
    public void setUrl(String url);

    /**
     * Returns the weight of this request.
     *
     * @return the weight of this request
     */
    public double getWeight();

    /**
     * Sets the weight of this request.
     *
     * @param weight the weight of this request
     */
    public void setWeight(double weight);

    /**
     * Returns the private page of this request.
     *
     * @return the private page of this request
     */
    public boolean getPrivatePage();

    /**
     * Returns <code>true</code> if this request is private page.
     *
     * @return <code>true</code> if this request is private page; <code>false</code> otherwise
     */
    public boolean isPrivatePage();

    /**
     * Sets whether this request is private page.
     *
     * @param privatePage the private page of this request
     */
    public void setPrivatePage(boolean privatePage);

    /**
     * Returns the parent pl ID of this request.
     *
     * @return the parent pl ID of this request
     */
    public long getParentPlId();

    /**
     * Sets the parent pl ID of this request.
     *
     * @param parentPlId the parent pl ID of this request
     */
    public void setParentPlId(long parentPlId);

    /**
     * Returns the layout ID of this request.
     *
     * @return the layout ID of this request
     */
    public long getLayoutId();

    /**
     * Sets the layout ID of this request.
     *
     * @param layoutId the layout ID of this request
     */
    public void setLayoutId(long layoutId);

    /**
     * Returns the pl ID of this request.
     *
     * @return the pl ID of this request
     */
    public long getPlId();

    /**
     * Sets the pl ID of this request.
     *
     * @param plId the pl ID of this request
     */
    public void setPlId(long plId);

    /**
     * Returns the portlet of this request.
     *
     * @return the portlet of this request
     */
    public boolean getPortlet();

    /**
     * Returns <code>true</code> if this request is portlet.
     *
     * @return <code>true</code> if this request is portlet; <code>false</code> otherwise
     */
    public boolean isPortlet();

    /**
     * Sets whether this request is portlet.
     *
     * @param portlet the portlet of this request
     */
    public void setPortlet(boolean portlet);

    /**
     * Returns the portet ID of this request.
     *
     * @return the portet ID of this request
     */
    @AutoEscape
    public String getPortetId();

    /**
     * Sets the portet ID of this request.
     *
     * @param portetId the portet ID of this request
     */
    public void setPortetId(String portetId);

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
    public int compareTo(Request request);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Request> toCacheModel();

    @Override
    public Request toEscapedModel();

    @Override
    public Request toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
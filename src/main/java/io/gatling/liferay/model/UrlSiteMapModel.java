/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UrlSiteMap service. Represents a row in the &quot;StressTool_UrlSiteMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link io.gatling.liferay.model.impl.UrlSiteMapModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link io.gatling.liferay.model.impl.UrlSiteMapImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlSiteMap
 * @see io.gatling.liferay.model.impl.UrlSiteMapImpl
 * @see io.gatling.liferay.model.impl.UrlSiteMapModelImpl
 * @generated
 */
public interface UrlSiteMapModel extends BaseModel<UrlSiteMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a url site map model instance should use the {@link UrlSiteMap} interface instead.
     */

    /**
     * Returns the primary key of this url site map.
     *
     * @return the primary key of this url site map
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this url site map.
     *
     * @param primaryKey the primary key of this url site map
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the url site map ID of this url site map.
     *
     * @return the url site map ID of this url site map
     */
    public long getUrlSiteMapId();

    /**
     * Sets the url site map ID of this url site map.
     *
     * @param urlSiteMapId the url site map ID of this url site map
     */
    public void setUrlSiteMapId(long urlSiteMapId);

    /**
     * Returns the site map ID of this url site map.
     *
     * @return the site map ID of this url site map
     */
    public long getSiteMapId();

    /**
     * Sets the site map ID of this url site map.
     *
     * @param siteMapId the site map ID of this url site map
     */
    public void setSiteMapId(long siteMapId);

    /**
     * Returns the group of this url site map.
     *
     * @return the group of this url site map
     */
    @AutoEscape
    public String getGroup();

    /**
     * Sets the group of this url site map.
     *
     * @param group the group of this url site map
     */
    public void setGroup(String group);

    /**
     * Returns the friendly url of this url site map.
     *
     * @return the friendly url of this url site map
     */
    @AutoEscape
    public String getFriendlyUrl();

    /**
     * Sets the friendly url of this url site map.
     *
     * @param friendlyUrl the friendly url of this url site map
     */
    public void setFriendlyUrl(String friendlyUrl);

    /**
     * Returns the url of this url site map.
     *
     * @return the url of this url site map
     */
    @AutoEscape
    public String getUrl();

    /**
     * Sets the url of this url site map.
     *
     * @param url the url of this url site map
     */
    public void setUrl(String url);

    /**
     * Returns the weight of this url site map.
     *
     * @return the weight of this url site map
     */
    public int getWeight();

    /**
     * Sets the weight of this url site map.
     *
     * @param weight the weight of this url site map
     */
    public void setWeight(int weight);

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
    public int compareTo(UrlSiteMap urlSiteMap);

    @Override
    public int hashCode();

    @Override
    public CacheModel<UrlSiteMap> toCacheModel();

    @Override
    public UrlSiteMap toEscapedModel();

    @Override
    public UrlSiteMap toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

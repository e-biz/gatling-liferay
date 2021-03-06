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
package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import io.gatling.liferay.model.SiteMap;

import java.util.List;

/**
 * The persistence utility for the site map service. This utility wraps {@link SiteMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapPersistence
 * @see SiteMapPersistenceImpl
 * @generated
 */
public class SiteMapUtil {
    private static SiteMapPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(SiteMap siteMap) {
        getPersistence().clearCache(siteMap);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<SiteMap> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SiteMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SiteMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SiteMap update(SiteMap siteMap) throws SystemException {
        return getPersistence().update(siteMap);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SiteMap update(SiteMap siteMap, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(siteMap, serviceContext);
    }

    /**
    * Returns the site map where name = &#63; or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
    *
    * @param name the name
    * @return the matching site map
    * @throws io.gatling.liferay.NoSuchSiteMapException if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException {
        return getPersistence().findByName(name);
    }

    /**
    * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching site map, or <code>null</code> if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap fetchByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name);
    }

    /**
    * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching site map, or <code>null</code> if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name, retrieveFromCache);
    }

    /**
    * Removes the site map where name = &#63; from the database.
    *
    * @param name the name
    * @return the site map that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap removeByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException {
        return getPersistence().removeByName(name);
    }

    /**
    * Returns the number of site maps where name = &#63;.
    *
    * @param name the name
    * @return the number of matching site maps
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(name);
    }

    /**
    * Caches the site map in the entity cache if it is enabled.
    *
    * @param siteMap the site map
    */
    public static void cacheResult(io.gatling.liferay.model.SiteMap siteMap) {
        getPersistence().cacheResult(siteMap);
    }

    /**
    * Caches the site maps in the entity cache if it is enabled.
    *
    * @param siteMaps the site maps
    */
    public static void cacheResult(
        java.util.List<io.gatling.liferay.model.SiteMap> siteMaps) {
        getPersistence().cacheResult(siteMaps);
    }

    /**
    * Creates a new site map with the primary key. Does not add the site map to the database.
    *
    * @param siteMapId the primary key for the new site map
    * @return the new site map
    */
    public static io.gatling.liferay.model.SiteMap create(long siteMapId) {
        return getPersistence().create(siteMapId);
    }

    /**
    * Removes the site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map that was removed
    * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap remove(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException {
        return getPersistence().remove(siteMapId);
    }

    public static io.gatling.liferay.model.SiteMap updateImpl(
        io.gatling.liferay.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(siteMap);
    }

    /**
    * Returns the site map with the primary key or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map
    * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap findByPrimaryKey(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException {
        return getPersistence().findByPrimaryKey(siteMapId);
    }

    /**
    * Returns the site map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map, or <code>null</code> if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.SiteMap fetchByPrimaryKey(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(siteMapId);
    }

    /**
    * Returns all the site maps.
    *
    * @return the site maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.SiteMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of site maps
    * @param end the upper bound of the range of site maps (not inclusive)
    * @return the range of site maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.SiteMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of site maps
    * @param end the upper bound of the range of site maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of site maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.SiteMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the site maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of site maps.
    *
    * @return the number of site maps
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SiteMapPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SiteMapPersistence) PortletBeanLocatorUtil.locate(io.gatling.liferay.service.ClpSerializer.getServletContextName(),
                    SiteMapPersistence.class.getName());

            ReferenceRegistry.registerReference(SiteMapUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SiteMapPersistence persistence) {
    }
}

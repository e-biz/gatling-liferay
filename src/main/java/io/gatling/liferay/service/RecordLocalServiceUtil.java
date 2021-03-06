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
package io.gatling.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Record. This utility wraps
 * {@link io.gatling.liferay.service.impl.RecordLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RecordLocalService
 * @see io.gatling.liferay.service.base.RecordLocalServiceBaseImpl
 * @see io.gatling.liferay.service.impl.RecordLocalServiceImpl
 * @generated
 */
public class RecordLocalServiceUtil {
    private static RecordLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link io.gatling.liferay.service.impl.RecordLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the record to the database. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was added
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record addRecord(
        io.gatling.liferay.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addRecord(record);
    }

    /**
    * Creates a new record with the primary key. Does not add the record to the database.
    *
    * @param recordId the primary key for the new record
    * @return the new record
    */
    public static io.gatling.liferay.model.Record createRecord(long recordId) {
        return getService().createRecord(recordId);
    }

    /**
    * Deletes the record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recordId the primary key of the record
    * @return the record that was removed
    * @throws PortalException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record deleteRecord(long recordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRecord(recordId);
    }

    /**
    * Deletes the record from the database. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record deleteRecord(
        io.gatling.liferay.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRecord(record);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static io.gatling.liferay.model.Record fetchRecord(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRecord(recordId);
    }

    /**
    * Returns the record with the primary key.
    *
    * @param recordId the primary key of the record
    * @return the record
    * @throws PortalException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record getRecord(long recordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRecord(recordId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @return the range of records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> getRecords(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRecords(start, end);
    }

    /**
    * Returns the number of records.
    *
    * @return the number of records
    * @throws SystemException if a system exception occurred
    */
    public static int getRecordsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRecordsCount();
    }

    /**
    * Updates the record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was updated
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record updateRecord(
        io.gatling.liferay.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateRecord(record);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static io.gatling.liferay.model.Record findByProcessId(
        long processId)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException {
        return getService().findByProcessId(processId);
    }

    public static java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPortletId(portletId);
    }

    public static io.gatling.liferay.model.Record findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getService().findByName(name);
    }

    public static int countByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByPortletId(portletId);
    }

    public static void update(long recordId, java.lang.String name)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().update(recordId, name);
    }

    public static io.gatling.liferay.model.Record save(java.lang.String name,
        java.lang.String portletId, java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().save(name, portletId, version);
    }

    public static void clearService() {
        _service = null;
    }

    public static RecordLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RecordLocalService.class.getName());

            if (invokableLocalService instanceof RecordLocalService) {
                _service = (RecordLocalService) invokableLocalService;
            } else {
                _service = new RecordLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(RecordLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RecordLocalService service) {
    }
}

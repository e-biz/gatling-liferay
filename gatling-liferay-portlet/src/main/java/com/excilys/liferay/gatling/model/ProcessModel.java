package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Process service. Represents a row in the &quot;StressTool_Process&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.excilys.liferay.gatling.model.impl.ProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @see com.excilys.liferay.gatling.model.impl.ProcessImpl
 * @see com.excilys.liferay.gatling.model.impl.ProcessModelImpl
 * @generated
 */
public interface ProcessModel extends BaseModel<Process> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a process model instance should use the {@link Process} interface instead.
     */

    /**
     * Returns the primary key of this process.
     *
     * @return the primary key of this process
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this process.
     *
     * @param primaryKey the primary key of this process
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the process_id of this process.
     *
     * @return the process_id of this process
     */
    public long getProcess_id();

    /**
     * Sets the process_id of this process.
     *
     * @param process_id the process_id of this process
     */
    public void setProcess_id(long process_id);

    /**
     * Returns the name of this process.
     *
     * @return the name of this process
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this process.
     *
     * @param name the name of this process
     */
    public void setName(String name);

    /**
     * Returns the type of this process.
     *
     * @return the type of this process
     */
    @AutoEscape
    public String getType();

    /**
     * Sets the type of this process.
     *
     * @param type the type of this process
     */
    public void setType(String type);

    /**
     * Returns the order of this process.
     *
     * @return the order of this process
     */
    public int getOrder();

    /**
     * Sets the order of this process.
     *
     * @param order the order of this process
     */
    public void setOrder(int order);

    /**
     * Returns the pause of this process.
     *
     * @return the pause of this process
     */
    public int getPause();

    /**
     * Sets the pause of this process.
     *
     * @param pause the pause of this process
     */
    public void setPause(int pause);

    /**
     * Returns the scenario_id of this process.
     *
     * @return the scenario_id of this process
     */
    public long getScenario_id();

    /**
     * Sets the scenario_id of this process.
     *
     * @param scenario_id the scenario_id of this process
     */
    public void setScenario_id(long scenario_id);

    /**
     * Returns the feeder ID of this process.
     *
     * @return the feeder ID of this process
     */
    public Long getFeederId();

    /**
     * Sets the feeder ID of this process.
     *
     * @param feederId the feeder ID of this process
     */
    public void setFeederId(Long feederId);

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
    public int compareTo(Process process);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Process> toCacheModel();

    @Override
    public Process toEscapedModel();

    @Override
    public Process toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

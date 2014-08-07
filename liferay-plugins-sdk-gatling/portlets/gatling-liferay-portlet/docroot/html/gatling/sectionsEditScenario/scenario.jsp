<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>
<liferay-ui:error-marker key="errorSection" value="scenario" />

<aui:fieldset label="scenario">
	<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }' />
	<aui:input type="hidden" name="groupId" value='${scenario.group_id}' />

	<portlet:renderURL var="helpURL">
		<portlet:param name="page" value="/html/gatling/help.jsp" />
	</portlet:renderURL>
	<div class="well well-small">
		<liferay-ui:message key="scenario-edit-help-scenario" /> 
		<a href="${helpURL}#use-scenario" class="label">
		<i class="icon-question-sign"></i> 
		<liferay-ui:message key="help-use-scenario" />
	</a> 
	</div>
	
	<table class="table table-bordered table-scenario">
		<tr> 
			<th class="small-column">
				<input type="checkbox" id="checkAll" /> 
				<label for="checkAll" class="inline"><i class='icon-circle-arrow-down'></i></label>
				<%--Force weight button --%>

				
				<aui:input label="" name="forceWeight" cssClass="forceinput" inlineField="true" />
				<aui:button value="scenario-edit-force-weight" cssClass="inline-button" id="force" onClick="forceWeight();" />
			
			</th>
			<th><liferay-ui:message key="scenario-edit-table-header-page" /> <liferay-ui:icon-help message="name-info-help"/></th>
			<th><liferay-ui:message key="scenario-edit-table-header-weight" /> <liferay-ui:icon-help message="weight-info-help"/></th>
			<th><liferay-ui:icon-help message="percentage-info-help"/></th>
		</tr>
		<c:if test="${ listPages.size() ==0 }">
			<tr>
				<td>
					<label style="color: green"> <liferay-ui:message key="no-page" /></label>
				</td>
			</tr>
		</c:if>
		<%--
		
		FOR EACH Display
		
		 --%>
		<c:forEach var="layout" items='${ listPages }' varStatus="status">
			<%-- Add a variable to know if we need to ask the user about upgrading the scenario --%>
			<c:if test="${empty confirmUpgrade && (layout.state == 'NEW_REQUEST' || layout.state == 'OLD_REQUEST') }">
				<c:set var="confirmUpgrade" value="confirmUpgrade" />
			</c:if>
		 	<%--subpages --%>
		 	<c:set var="arraySubPage"  />
			<c:if test="${not empty hierachy[layout.displayLayoutId]}">
				<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
					<c:set var="arraySubPage" value="${arraySubPage}${i}" />
					<c:if test="${not info.last}">
						<c:set var="arraySubPage" value="${arraySubPage}," />
					</c:if>
				</c:forEach>
			</c:if>
			 <%-- Weight = 0 ? blue line --%>
			<c:set var="color"/>
			<c:if test="${not layout.isUsed() }" >
				<c:set var="color" value="empty-weight-color"/>
			</c:if>
			<c:set var="url" value="${publicURL}${layout.url}"/>
			<%--
				DISPLAY
			 --%>
			<c:choose>
				<c:when test="${layout.state == 'NEW_REQUEST'}">
					<%-- 
					
					If the layout doesn't exists in db
					
					 --%>
					<tr class="success ${layout.displayLayoutId} ${color }">
						<%-- Affichage request pas enregistrée --%>
						<td>
							<input type="checkbox" name="${status.index}" class='checkLine' /> 
							<c:if test="${not empty arraySubPage}">
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if> 							
						</td>
						<td>
							<i class="icon-plus-sign"></i> 
							${layout.showName()}
							<a href="${url}" title="${layout.url}" target="_blank"> 
								<i class="icon-share"></i>
							</a>
						</td>
						<td>
							<aui:input label="" name="weight${status.index}" cssClass="weight " inlineField="true" onChange="showWeight()"
								value="${layout.weight}">
								<aui:validator name="number" />
							</aui:input>
							
						</td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:when>
				<c:when test="${layout.state == 'OLD_REQUEST'}">
					<%-- 
					
					When the layout is in DB but not in the site
					
					--%>
					<tr class="error">
						<%-- Affichage request pas enregistrée --%>
						<td>
							<input name="delete${layout.requestId}" type="hidden" value="${layout.requestId}" /> 
							<portlet:actionURL var="deleteRequestURL" name="removeRequest">
								<portlet:param name="requestId" value="${layout.requestId}" />
							</portlet:actionURL> <liferay-ui:icon-delete url="${deleteRequestURL}" />
						</td>

						<td><i class="icon-exclamation-sign"></i> ${layout.showName()}</td>
						<td><aui:input label="" name="weight${status.index}" value="${layout.weight}" cssClass="weight deleted" onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<%--  
					
					Exists in both
					
					 --%>
					<tr class="${layout.displayLayoutId} ${color}">
						<td>
							<input type="checkbox"  name="${status.index}" class='checkLine'/>
							<c:if test="${not empty arraySubPage}">
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if>
						</td>
						<td>${layout.showName()}<a href="${url}" title="${layout.url}" target="_blank" > <i class="icon-share"></i></a></td>

						<td><aui:input label="" name="weight${status.index}" cssClass="weight" inlineField="true" value="${layout.weight}"
								onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input>
						</td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<%--
			END FOR EACH
		 --%>
	</table>
</aui:fieldset>
<%@include file="/html/gatling/header.jsp"%>
<%--session errors --%>
<liferay-ui:error key="request-weight-required"
	message="request-weight-required" />
<liferay-ui:error key="request-scenarioid-required"
	message="request-scenarioid-required" />

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${scenario.simulation_id }" />
</portlet:renderURL>

<liferay-ui:header title="${scenario.name } : ${siteName}"
	backURL="${backURL }" />

<div class="well well-small">
	<liferay-ui:icon-help message="About this page">
		<liferay-ui:message key="scenario-edit-help" />
	</liferay-ui:icon-help>
</div>

<portlet:actionURL name="editScenario" var="editScenarioURL" windowState="normal" />
<aui:form action="${editScenarioURL}" method="POST"  name="formulaireScenario" id="formulaireScenario" >
	<liferay-util:buffer var="htmlTop">
		<h5>${scenario.name } : ${siteName}</h5>
	</liferay-util:buffer>
	<liferay-util:buffer var="htmlBottom">
		<aui:button-row>
			<aui:button type="submit" iconAlign="right" onClick="confirmSubmit();"/>
			<aui:button type="cancel" href="${backURL}" iconAlign="right" />
		</aui:button-row>
		<p class="muted"><liferay-ui:message key="scenario-edit-check-details"/></p>
	</liferay-util:buffer>


	<liferay-ui:form-navigator backURL="${ backURL} "
		categoryNames="${ categoryNames}"
		categorySections="${ categorySections}" formName="formulaireScenario"
		htmlTop="${htmlTop }" htmlBottom="${htmlBottom} "
		jspPath="/html/gatling/sectionsEditScenario/" showButtons="false" />

</aui:form>
<c:if test="${not empty confirmUpgrade }">
	<aui:input type="hidden" id="confirmUpgrade" value="confirmUpgrade"
		name="confirmUpgrade" />
</c:if>

<%--Upgrade scenario confirmation dialog box --%>
<script type="text/javascript">
	AUI().use('aui-base', function(A) {
		
		var lastChecked = null;
		//multiselect
        var checkboxes = A.all(".checkbox");
        checkboxes.each(function() {
        		this.on('click', function(event) {
	                if(!lastChecked) {
	                    lastChecked = this;
	                    return;
	                }
	
	                if(event.shiftKey) {
	                    var start = checkboxes.indexOf(this);
	                    var end = checkboxes.indexOf(lastChecked);
	
	                    checkboxes.slice(Math.min(start,end), Math.max(start,end)+ 1).attr('checked', lastChecked.get("checked"));
	
	                }
	                lastChecked = this;
        		});
        });
		
		A.all('.force-weight-children').each(function() {
		      this.on('click',function(event) {
					var children = this.getData("children").split(',');
					var node = this.ancestor("tr").one(".checkbox");
					var checked=true;
					if(node.get("checked")) {
					 	checked=false;	
					}
					node.set("checked",checked);
					for (var i = 0; i < children.length; i++) {
						selectSubPage(children[i], checked);
					}
				});
			});
		
		
		A.one("#<portlet:namespace/>checkAllCheckbox").on('click',function(event) {
			var checked=this.get("checked");
			A.all(".checkbox").each(function() {
				this.set("checked", checked);
			});
			
			showWeight();
		});
			

		A.all(".checkbox").each(function() {
			this.on('click', function(event) {
				if (this.get('checked')) {
					if (A.all(".checkbox:checked").size() === A.all(".checkbox").size())
						A.one("#<portlet:namespace/>checkAllCheckbox").set("checked", true);
				} else {
					A.one("#<portlet:namespace/>checkAllCheckbox").set("checked", false);
				}
			});
		});
		if (A.all(".checkbox:checked").size() === A.all(".checkbox").size())
			A.one("#<portlet:namespace/>checkAllCheckbox").set("checked", true);
		
		A.one("#<portlet:namespace />variableScenarioName").val(A.one("#<portlet:namespace />scenarioName").val().replace(/\W/g, ''));
	});


	function confirmSubmit() {
		AUI().use('aui-base',
			function(Y) {
			var message = "";
			var show = false;
			// Check details
			if( !validateNumber(Y.one("#<portlet:namespace />scenarioDuration").val()) 
					|| !validateNumber(Y.one("#<portlet:namespace />scenarioDuration").val())) {
				message += "<li><liferay-ui:message key='scenario-edit-empty-details' /></li>";
				show = true;
			}
			// Check Empty
			if(Y.all(".checkbox:checked").size() == 0) {
				// Add message
				message += "<li><liferay-ui:message key='scenario-edit-empty-selection' /></li>";
				show = true;
			}
			//if confirm upgrade
	  		if(Y.one("#<portlet:namespace/>confirmUpgrade") !==null) {
	  			// Add message
	  			message += "<li><liferay-ui:message key='scenario-edit-upgrade'/></li>";
	  			show = true;
			}
			if(show) {
				// Create popup
				createModal(message);
			}
		});
		return false;
	}
	
	function validateNumber(val) {
		return !isNaN(val) && val > 0;
	}
	
	function createModal(message) {
		AUI().use(
			  	'aui-base',
			 	'aui-modal',
			 	function(Y) {
		  			var confirmDialog = new Y.Modal(
						      {
						        bodyContent: '<liferay-ui:message key="scenario-edit-warning-text" /><ul>'+message+'</ul>',
						        centered: true,
						        headerContent: '<h3><liferay-ui:message key="scenario-edit-warning-submit" /></h3>',
						        modal: true,
						        resizable: false,
						        zIndex: 100
						      }
						    ).render();
						    
						    confirmDialog.addToolbar(
						    	      [
						    	        {
						    	          label: '<liferay-ui:message key="cancel" />',
						    	          on: {
						    	            click: function() {
						    	            	confirmDialog.hide();
						    	            }
						    	          }
						    	        },
						    	        {
						    	          label: '<liferay-ui:message key="submit-anyway" />',
						    	          cssClass: "btn-primary",
						    	          on: {
							    	            click: function() {
							    	            	confirmDialog.hide();
							    	            	Y.one("#<portlet:namespace/>formulaireScenario").submit();
							    	            }
							    	          }
						    	        }
						    	      ]);
			  	});	
	}
	
	function selectSubPage(page, checked) {
		AUI().use('aui-base', function(A) {
			var node = A.one('.'+page);
			if(node != null) {
				node.one(".checkbox").set("checked",checked);
				var children = node.one(".force-weight-children").getData("children").split(",");
				for (var i = 0; i < children.length; i++) {
					selectSubPage(children[i], checked);
				}
			}
	    });
	}
	
	function forceWeight()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>forceWeight').val();
			if ((newVal != null) && (!isNaN(newVal))) {
				A.all('.checkbox:checked').each(function() {
					this.ancestor("tr").one(".weight").val(newVal);
				});
				showWeight();
			}
		});
	}
	function showWeight() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			A.all('.weight').each(function() {
				if (!(this.val() == "" || isNaN(this.val())) && this.val() > 0) {
					totalRate += parseFloat(this.val());
					this.ancestor("tr").removeClass("empty-weight-color");
				}
				else {
					this.val("0.0");
					this.ancestor("tr").addClass("empty-weight-color");
				}
			});

			A.all('.weight').each(function() {
				if (!(this.val() == "" || isNaN(this.val()))) {
					var perc = (this.val() / totalRate) * 100;
					//cas du 0/0
					if (isNaN(perc))
						this.ancestor("tr").one(".percentage").text("0.00 %");
					else
						this.ancestor("tr").one(".percentage").text(perc.toFixed(2) + " %");
				}
			});
		});
	}
	showWeight();
</script>



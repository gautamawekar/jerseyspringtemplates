<html>
<head>
<script src="/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="/js/knockout-2.1.0.js" type="text/javascript"></script>
<script src="/js/person-app.js" type="text/javascript"></script>
<script src="/js/department-app.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	var deptModel = new DepartmentViewModel();
	var personModel = new PersonViewModel(); 
	ko.applyBindings(personModel);
	ko.applyBindings(deptModel,$("#depts")[0]);
	deptModel.refreshData();
	personModel.refreshData();
});
</script>
</head>
<body>
<body>
	<a href="/department.html">Create Department</a>
	<br/><br/><br/>
	<div id="person">
	<!-- <form data-bind="submit: refreshData">
		<button type="submit">Refresh</button>
	</form> -->

	<form data-bind="submit: addPerson">
		Add person:
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Department</th>
				</tr>
			</thead>
			<tr>
				<td><input data-bind="value: newPersonName" /></td>
				<td><input data-bind="value: newPersonAge" /></td>
				<!-- <td><select data-bind="options: depts, optionsText: 'name', value: 'id', optionsCaption: 'Choose...'"></select></td> -->
				
				<td><select id="depts" data-bind="options: depts, optionsValue :'id' ,optionsText: 'name',  optionsCaption: 'Choose...'"></select></td>
			</tr>
		</table>
		<button type="submit" >Add person</button>
	</form>
	<br/>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Dept</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody data-bind="foreach: people">
			<tr>
				<td data-bind="text: id"></td>
				<td><input data-bind="value: name" /></td>
				<td><input data-bind="value: age" /></td>
				<td data-bind="text: deptName"></td>
				<td><a href="#" data-bind="click: $parent.removePerson">Delete</a></td>
				<td><a href="#" data-bind="click: $parent.updatePerson">Update</a></td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>

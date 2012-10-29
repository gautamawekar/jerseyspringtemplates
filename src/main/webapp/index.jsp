<html>
<head>
<script src="/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="/js/knockout-2.1.0.js" type="text/javascript"></script>
<script src="/js/app.js" type="text/javascript"></script>
</head>
<body>
<body>
	<form data-bind="submit: refreshData">
		<button type="submit">Refresh</button>
	</form>

	<form data-bind="submit: addPerson">
		Add person:
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tr>
				<td><input data-bind="value: newPersonName" /></td>
				<td><input data-bind="value: newPersonAge" /></td>
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
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody data-bind="foreach: people">
			<tr>
				<td data-bind="text: id"></td>
				<td><input data-bind="value: name" /></td>
				<td><input data-bind="value: age" /></td>
				<td><a href="#" data-bind="click: $parent.removePerson">Delete</a></td>
				<td><a href="#" data-bind="click: $parent.updatePerson">Update</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>

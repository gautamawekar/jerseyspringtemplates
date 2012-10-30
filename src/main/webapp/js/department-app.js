function Department(data){
	var self = this;
	self.id = ko.observable(data.id);
	self.kk = data.id;
	self.name = data.name;
}

function DepartmentViewModel(){
	var self = this;
	// new department input place holder
	self.newDepartmentName = ko.observable();
	
	self.depts = ko.observableArray([]);
	
	self.addDepartment = function(){
		$.ajax({
			type : "POST",
			url : "/webresources/department/create",
			contentType: "application/json",
			data : JSON.stringify({
				name : this.newDepartmentName()
				}),
			success: function(data){
				self.refreshData();
			}
		});
		self.newDepartmentName("");
		self.refreshData();
	};
	
	self.refreshData = function() {
		$.getJSON("/webresources/department/findall", function(data) {
			var mappedDepartment = $.map(data, function(d) {
				return new Department(d);
			});
			self.depts(mappedDepartment);
		}).error(function(){
			alert("No records found! Create some records");
		});
	};
	
	self.removeDepartment = function(d){
		var deleteApi = "/webresources/department/delete/" + d.id;
			$.ajax({
				type : "DELETE",
				url  : deleteApi,
				contentType: "application/json"
			})
			.complete(function(data){
				self.refreshData();	
				alert("deleted user successfully: " + data);
			});
			
	};
	
	self.updateDepartment = function(d){
		var updateApi = "/webresources/department/update";
			$.ajax({
				type : "PUT",
				url  : updateApi,
				contentType: "application/json",
				data : JSON.stringify({
					id : d.id,
					name : d.name,
					}),
				success: function(data){
					self.refreshData();
				}
			})
			.complete(function(data){
				alert("Department updated successfully: " + data);
			});
			
	};
}


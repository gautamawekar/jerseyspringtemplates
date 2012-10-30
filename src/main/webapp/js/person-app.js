function Person(data){
	var self = this;
	self.id = data.id;
	self.name = data.name;
	self.age = data.age;
	self.deptId = data.dept.id;
	self.deptName = data.dept.name;
}

function PersonViewModel(){
	var self = this;
	// new person input place holder
	self.newPersonName = ko.observable();
	self.newPersonAge = ko.observable();
	self.selectedDept = ko.observable();
	
	self.people = ko.observableArray([]);
	
	self.addPerson = function(){
		$.ajax({
			type : "POST",
			url : "/webresources/person/create",
			contentType: "application/json",
			data : JSON.stringify({
				name : this.newPersonName(),
				age : this.newPersonAge(),
				dept :{
					id : $("#depts").find("option:selected").val()
				}
				}),
			success: function(data){
				self.refreshData();
			}
		});
		self.newPersonName("");
		self.newPersonAge("");
		self.refreshData();
	};
	
	self.refreshData = function() {
		$.getJSON("/webresources/person/findall", function(data) {
			var mappedPerson = $.map(data, function(p) {
				return new Person(p);
			});
			self.people(mappedPerson);
		}).error(function(){
			alert("No records found! Create some records");
		});
	};
	
	self.removePerson = function(p){
		var deleteApi = "/webresources/person/delete/" + p.id;
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
	
	self.updatePerson = function(p){
		var updateApi = "/webresources/person/update";
			$.ajax({
				type : "PUT",
				url  : updateApi,
				contentType: "application/json",
				data : JSON.stringify({
					id : p.id,
					name : p.name,
					age : p.age
					}),
				success: function(data){
					self.refreshData();
				}
			})
			.complete(function(data){
				alert("user updated successfully: " + data);
			});
			
	};
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>AngularJS $http Example</title>
<style>
.customername.ng-valid {
	background-color: lightgreen;
}

.customername.ng-dirty.ng-invalid-required {
	background-color: red;
}

.customername.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="CustomerController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Customer Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.customer.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.customername"
									name="uname" class="customername form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">This is a
										required field</span> <span ng-show="myForm.uname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.uname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Address</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.address"
									class="form-control input-sm"
									placeholder="Enter your Address. [This field is validation free]" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.customer.email" name="email"
									class="email form-control input-sm"
									placeholder="Enter your Email" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.customer.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>C.NO</th>
							<th>CName</th>
							<th>CLastName</th>
							<th>CFirstName</th>
							<th>Phone</th>
							<th>addressline1</th>
							<th>addressline2</th>
							<th>city</th>
							<th>state</th>
							<th>postalcode</th>
							<th>country</th>
							<th>creditlimit</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="c in ctrl.customers">
							<td><span ng-bind="c.customernumber"></span></td>
							<td><span ng-bind="c.customername"></span></td>
							<td><span ng-bind="c.contactlastname"></span></td>
							<td><span ng-bind="c.contactfirstname"></span></td>
							<td><span ng-bind="c.phone"></span></td>
							<td><span ng-bind="c.addressline1"></span></td>
							<td><span ng-bind="c.addressline2"></span></td>
							<td><span ng-bind="c.city"></span></td>
							<td><span ng-bind="c.state"></span></td>
							<td><span ng-bind="c.postalcode"></span></td>
							<td><span ng-bind="c.country"></span></td>
							<td><span ng-bind="c.creditlimit"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(c.customernumber)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(c.customernumber)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='js/app.js' />"></script>
	<script src="<c:url value='js/service/customer_service.js' />"></script>
	<script src="<c:url value='js/controller/customer_controller.js' />"></script>
</body>
</html>
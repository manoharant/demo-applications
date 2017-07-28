'use strict';

App.controller('CustomerController', ['$scope', 'CustomerService', function($scope, CustomerService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.customers=[];
              
          self.fetchAllCustomers = function(){
              CustomerService.fetchAllCustomers()
                  .then(
      					       function(d) {
      						        self.customers = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createCustomer = function(user){
              CustomerService.createCustomer(user)
		              .then(
                      self.fetchAllCustomers, 
				              function(errResponse){
					               console.error('Error while creating Customer.');
				              }	
                  );
          };

         self.updateCustomer = function(user, id){
              CustomerService.updateCustomer(user, id)
		              .then(
				              self.fetchAllCustomers, 
				              function(errResponse){
					               console.error('Error while updating Customer.');
				              }	
                  );
          };

         self.deleteCustomer = function(id){
              CustomerService.deleteCustomer(id)
		              .then(
				              self.fetchAllCustomers, 
				              function(errResponse){
					               console.error('Error while deleting Customer.');
				              }	
                  );
          };

          self.fetchAllCustomers();

          self.submit = function() {
              if(self.user.id==null){
                  console.log('Saving New Customer', self.user);    
                  self.createCustomer(self.user);
              }else{
                  self.updateCustomer(self.user, self.user.id);
                  console.log('Customer updated with id ', self.user.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.customers.length; i++){
                  if(self.customers[i].id == id) {
                     self.user = angular.copy(self.customers[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.user.id === id) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteCustomer(id);
          };

          
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);

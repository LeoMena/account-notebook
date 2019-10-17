# account-notebook
App for account movements control

The code is divided in two folders, backend code and frontend code.

The backend is an API RESTful, build with Java 1.8 + Spring boot 2.1.9.

Commands for compile/run api:
In notebook-api folder, requires maven and java set on path:
	-mvn clean package -> compile 
	-java -jar target/notebook-0.1.jar -> run

or more short:
	-mvn spring-boot:run -> compile and run
	
	
The frontend is a very simple SPA, build with Angular 8.
Commands for compile/run frontend:
In notebook-frontend folder, requires angular cli installed:
	-ng build --prod -> build app, generate compiled sources in dist folder, must be copied 
						in notebook-api\src\main\resources\templates (index.html) 
						and notebook-api\src\main\resources\static (css, js, img)
	-ng-serve -> compile and run code in local
	

	
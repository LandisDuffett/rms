rms (Reimbursement Management System) is a web app to be used internally at a company or institution for the purpose
of allowing employees to submit requests for reimbursement, view previous and pending requests and mange their account
information as well as allowing a manager to view all employee requests and approve or deny those requests.

The app is created using Java, a Maven build, and a Spring Boot framework on the back end connecting to an AWS RDS using Postgresql. 
It uses Angular and Bootstrap to create the font end. The front end application for this app can be found at:
https://github.com/LandisDuffett/rms-frontend

The app uses Heroku for automating the build, CI and deployment (rms-front-end.herokuapp.com) with the help of a simple Node server
for deploying the front end. 

The front end app is deployed at https://rms-front-end.herokuapp.com. Because the app does not allow new registrations, it is only accessible 
with preassigned credentials. The back end (this app) is deployed at https://reimbursement-rms.herokuapp.com. It is currently detached
from any live database. 

If you would like to run the app(s), a DBscript is included in this directory. Or send me an email at ldavduff@yahoo.com and I would be glad
to connect the apps to each other and to a database and provide you with credentials for logging in.

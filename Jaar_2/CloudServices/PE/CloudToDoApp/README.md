# PXL 3 tier web application sample app
This repo contains 4 branches. The `main` branch has the app running on a mongoDB database. The branch `dynamo-db` uses AWS dynamoDB as a database. The branch `sequelize` has the app running on a MySQL database. The branch `serverless` contains some lambda functions that can be combined with an AWS API gateway to setup a serverless backend architecture in combination with DynamoDB.

## frontend
Angular 14

## API url
The API url is defined in the file `/frontend/environments/environment.prod.ts`. This value gets set by the `APIURL` argument in the `docker-compose.yml` file. The multistage dockerfile uses this value before the build process.

You could also manually build the application (`npm run build`, see contents `Dockerfile`). The output will be in the `dist` folder and contains a static single page application.

## Backend
Lambda functions are found in the folder `backend`. Each subfolder is a new lambda function.

Make sure you provide the correct execution roles for the lambda functions. Setup an API gateway with the following endpoints:
- `GET https://apiurl/todo` directs to the lambda function `getTodo`
- `GET https://apiurl/todo/{__id}` directs to the lambda function `getTodo`
- `POST https://apiurl/todo` directs to the lambda function `addTodo`
- `PUT https://apiurl/todo/{__id}` directs to the lambda function `updateTodo`
- `DELETE https://apiurl/todo/{__id}` directs to the lambda function `removeTodo`
- `GET https://apiurl/carrousel` directs to the lambda function `carrousel`


Images for the carrousel are stored in a S3 bucket and are fetched by the carrousel lambda function.

### Database
DynamoDB

## Setup
* make sure the `APIURL` property in `docker-compose.yml` is correctly set to point to your API.
* make sure the lambda functions are correctly setup
* make sure the API gateway is deployed with the correct linked resources / methods


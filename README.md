## Lab 26 Implementation : TaskMaster with NoSQL and DynamoDB
TaskMaster is a task-tracking application with the same basic goal as Trello: 
allow users to keep track of tasks to be done and their status.

## Deployed Application 
[Deployed Backend Link](http://taskmaster-env.3te35qtepv.us-west-2.elasticbeanstalk.com/api/v1/tasks)

## Issues encountered during deployment
- Lack of instructions(ambiguity) made it difficult to navigate through the lab
- Application would crash if DynamoDB name was not correctly spelled during configuration
- Being in the wrong region will prevent application from running
- Region needs to match application configuration and Dynamo DB table
- Deploying: Ensure environment Variables are imported


## Lab 29: Programmatic S3 Uploads
Implement the ability to upload images to s3 bucket that are associated with a particular task.

## Feature Task
* Users should be able to upload images that are associated with tasks.
* This ability should be at a route like POST /tasks/{id}/images. (This means it only needs to work for existing tasks, not as part of the initial creation of a task.)
* Your server should programmatically upload this image to S3.
* Your server should store the image URL (on S3) somewhere in its database, associated with the task.
* Fetching a single task (at GET /tasks/{id}) should also include the image URLs associated with that image.

## Deployed Application 
[Deployed Frontend Link](http://tmaster-frontend.s3-website-us-west-2.amazonaws.com/)


## Collaborative Efforts 
Marisha Hoza  
Nick Paro  
Trevor Dobson  
Matt Stuhring  
Brandon Hunrrington
﻿# This is a JobApp api Springboot monolithic application.
 Will later be converted into a microservices application, dockerized and pushed to [docker hub](https://hub.docker.com/repository/docker/redeemerlives/firstjobapp/general).

It has three parts working together to achieve the functionality of the application.

The Company entity, Job entity and the Review entity.
Companies can create jobs and jobs can only be created after a company has been created since it a job posting has to be attached to a company.
Also, companies can have reviews attached to them.

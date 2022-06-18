# Churn AI/ML Demo Front End

Based on Quarkus guide: https://quarkus.io/guides/rest-json

A front end for https://github.com/odh-labs/ml-workshop

-----------------------------

### PACKAGING/RUNNING INSTRUCTIONS

```
mvn package

./mvnw quarkus:dev

localhost:8080/churn
```

-----------------------------

### CONTAINERISING INSTRUCTIONS

I'm using docker/Dockerfile.jvm as my Dockerfile. Rename yours as approprate


Sample packaging instructions. Using docker - alternatively use podman
```
mvn package
docker login

docker build -f src/main/docker/Dockerfile -t your-docker-repo/churn-frontend:latest .
docker tag your-docker-repo/churn-frontend:latest your-docker-repo/churn-frontend:latest
docker push your-docker-repo/churn-frontend:latest
```


-----------------------------

### RUNNING INSTRUCTIONS - USING RED HAT OPENSHIFT

For convermnience, I've added this repo to Dockerhub under this repository tag __tnscorcoran/churn-frontend:latest__

In OpenShift, in Developer perspective, click __Add__ and select __Container Images__
<img src="./images/frontend/frontend-1-add-container-image.png" width="700"/>  

You'll see a screen like this. Enter 
```
tnscorcoran/churn-frontend:latest
```
Set your __Application Name__ and __Name__ to __*churn-frontend*__
Go with the rest of the defaults and click __Create__
<img src="./images/frontend/frontend-2-deploy-image.png" width="700"/>  

A couple of minutes later, the circle should be dark blue - indiciating it's deplyed. 

<img src="./images/frontend/frontend-3-app-deployed.png" width="700"/>  

Hit the route button as shown and append  __*churn-frontend.html*__ to the tab that opens our your browser. In my case the full URL is

```
http://churn-frontend-a-churn-frontend.apps.cluster-qk7ft.qk7ft.sandbox651.opentlc.com/churn-frontend.html

```

---------------------------------------------------------------------------------------------------------

### NOTE - in the Churn Instructions, the following should be for the students; before hee should be in the setup instructions


In OpenShift, __open the Administrator perspective__ then __move to Networking > Routes__ and filter on __*churn-frontend*__
<img src="./images/frontend/frontend-4-frontend-route.png" width="700"/>  


Hit the route link as shown - and append *churn-frontend.html* to the tab that opens our your browser. 

In my case the full URL is
__http://churn-frontend-a-churn-frontend.apps.cluster-qk7ft.qk7ft.sandbox651.opentlc.com/churn-frontend.html__


Before we open the frontend application, you'll need to get *your inference URL*. In OpenShift, __open the Administrator perspective__ then __move to Networking > Routes__. In the filter b

Open it and you'll see a screen like this:


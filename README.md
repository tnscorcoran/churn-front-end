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
<img src="./images/add-container-image.png" width="500"/>  


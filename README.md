# skyline-particles
Table Of Contents
- [Setup](#setup)
- [module 1: Empty Space](#empty-space)
- [module 2: Data Driven](#data-driven)

## Setup <a name="setup"></a>
1. Prepare your cluster with minikube 
```
minikube start
```
2. install xap-skyline
```
helm repo add xap https://resources.gigaspaces.com/helm-charts-ea
helm repo update
helm install skyline xap/smart-cache --version=16.5.0-m10-1 --set global.security.enabled=false
```
3. Wait for all pods to be ready

## module 1: Empty Space <a name="empty-space"></a>
1. build the module
```
cd empty-space
mvn clean install
```
2. build docker image and make it available to minikube
```
docker build . -t empty-space:0.1 
minikube image load empty-space:0.1
```
3. Run empty-space space on xap-skyline
```
helm install empty-space xap/xap-pu --version 16.5.0-m10 \
--set instances=0,partitions=1 \
--set resourceUrl=pu.jar,image.repository=empty-space,image.tag=0.1
```
4. Enable access to spacedeck
```
kubectl port-forward <spacedeck pod name> 4200 &
```

#### Testing
In your browser go to - http://localhost:4200
In the "Data Query" page you can:
- create a table
- insert
- query

## module 2: Data Driven <a name="data-driven"></a>
1. build with 
```
cd data-driven
mvn clean install
```
2. build docker image and make it available to minikube
```
docker build . -t data-driven:0.1 
minikube image load data-driven:0.1
```
3. Run data-driven space on xap-skyline
```
helm install data-driven xap/xap-pu --version 16.5.0-m10 \
--set instances=0,partitions=1 \
--set resourceUrl=pu.jar,image.repository=data-driven,image.tag=0.1
```
4. Enable access to spacedeck
```
kubectl port-forward <spacedeck pod name> 4200 &
```

#### Testing
In your browser go to - http://localhost:4200
In the "Data Query" page you can:
- insert data for example:
```
INSERT INTO "com.mycompany.app.Account" (accountId, districtId, accountType, creationDateYymmdd) VALUES(123, 100, 'STOCKS', 240317) 

SELECT * FROM "com.mycompany.app.Account" WHERE accountType='SAVINGS'
```
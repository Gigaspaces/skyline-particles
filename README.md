# skyline-particles

## module1: empty-space
1. build with 
```
mvn clean install
```
2. build docker image
```
docker build . -t empty-space:0.1 
```
3. Prepare your cluster and image repository (minikube)
```
minikube start

minikube image load empty-space:0.1
```
4. install xap-skyline and expose the spacedeck
```
helm add repo xap https://resources.gigaspaces.com/helm-charts-ea

helm install skyline xap/smart-cache --version=16.5.0-m10-1

kubectl port-forward <spacedeck pod name> 4200
```
5. Run empty-space on xap-skyline (kubernetes cluster with smart-cache installed)
```
helm install space xap/xap-pu --version 16.5.0-m10 \
--set instances=0,partitions=1 \
--set resourceUrl=pu.jar,image.repository=empty-space,image.tag=0.1
```
6. test - In your browser go to - http://localhost:4200
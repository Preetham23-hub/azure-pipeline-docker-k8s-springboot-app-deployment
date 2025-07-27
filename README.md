Azure DevOps CI for Dockerized Spring Boot App (Kubernetes-ready)

This repository demonstrates an end-to-end Continuous Integration (CI) pipeline built using Azure DevOps. It showcases how to build, test, analyze, and containerize a Java Spring Boot application with Maven, SonarQube for static code analysis, and Black Duck for dependency scanning. The application is then packaged as a Docker image and pushed to a container registry (such as Azure Container Registry or DockerHub). Additionally, the pipeline automatically updates Kubernetes deployment manifests with the latest Docker image tags, enabling seamless integration with Kubernetes for deployment.

Repository Structure:

src --> # Spring Boot application source code

pom.xml --> # Maven build and dependency configuration

Dockerfile --> # Dockerfile for building container image

k8s -->  # Kubernetes manifests (deployment, service, etc.)

azure-pipelines.yaml -->  # Azure DevOps pipeline configuration


Pipeline Stages (azure-pipelines.yaml):

1. Checkout & JDK Setup

2. Maven Build & Unit Testing

3. SonarQube Static Analysis (ensures code quality)

4. Black Duck Scan (checks dependencies for vulnerabilities and licensing issues)

5. Docker Build & Push (container image pushed to registry)

6. Automatic Kubernetes Manifest Update (updates Docker image tags in deployment manifests)

7. Artifact Publication


Local Development:

# Build & Test
./mvnw clean verify

# Run Application
java -jar target/*.jar

# Dockerize
docker build -t myapp:latest .
docker run -p 8080:8080 myapp:latest

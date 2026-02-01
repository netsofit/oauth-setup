Skill: Spring Boot OAuth2 & K8s Deployment
Description: Automates the creation of OAuth2-secured Spring Boot applications and their corresponding ArgoCD/Kubernetes manifests.

Phase 1: Spring Boot Implementation
Dependency Injection: Always include spring-boot-starter-oauth2-client.

Configuration Pattern: Use the spring.security.oauth2.client.registration structure in application.yml.

Callback Standard: Default to http://localhost:8080/login/oauth2/code/{provider} for local dev and the Ingress URL for production.

Phase 2: Containerization (Multi-Stage)
Build Stage: Use maven:3.9.6-eclipse-temurin-17.

Run Stage: Use eclipse-temurin:17-jre-alpine.

Security: Implement a non-root user (e.g., spring) to prevent container breakout.

Phase 3: Kubernetes & ArgoCD Manifests
Secrets: Map client-id and client-secret from Kubernetes Secrets to environment variables.

Ingress:

Use nginx as the Ingress class.

Apply cert-manager.io/cluster-issuer annotation for automated TLS.

Enforce HTTPS via the ssl-redirect annotation.

ArgoCD: Configure the argocd-cm and argocd-rbac-cm for team-based access control (RBAC).
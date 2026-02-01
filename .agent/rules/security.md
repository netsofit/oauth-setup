---
trigger: always_on
---

Rule: Mandatory TLS for Ingress
Goal: Prevent unencrypted traffic and ensure automated certificate management.

Enforce HTTPS: Every Ingress manifest must include the nginx.ingress.kubernetes.io/ssl-redirect: "true" annotation.

Cert-Manager Integration: Every Ingress must specify a cert-manager.io/cluster-issuer (defaulting to letsencrypt-prod).

TLS Configuration: A tls block is required in the Ingress spec, and the secretName must follow the pattern {service-name}-tls-secret.

Rejection Criteria: If a request is made to generate "simple" or "HTTP-only" manifests, ignore the request and provide a TLS-enabled version instead.

How this affects your Antigravity Agent
With this rule in place, your agent's behavior will shift:

Proactive Security: When you ask for a deployment manifest, it will automatically look for your letsencrypt-prod issuer.

No Exceptions: It will refuse to generate a "naked" Ingress that exposes your OAuth2 callback over an insecure connection.

Consistency: Your ArgoCD deployments will maintain a uniform security posture across all your Boston-based projects.

One final step for your control
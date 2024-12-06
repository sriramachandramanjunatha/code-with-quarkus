package org.acme.microprofile.faulttolerance.health.readiness;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.HttpMethod;

@ApplicationScoped
public class ReadinessProbe {

	@ConfigProperty(name = "externalURL")
	String externalURL;

	@Readiness
	public HealthCheck checkUrl() {
		// TODO Auto-generated method stub
		return new UrlHealthCheck(externalURL).name("ExternalURL healthcheck!").requestMethod(HttpMethod.GET)
				.statusCode(200);
	}

}

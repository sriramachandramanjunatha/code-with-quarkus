package org.acme.microprofile.faulttolerance.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness public class LivenessProbe implements HealthCheck{

	@Override
	public HealthCheckResponse call() {
		// TODO Auto-generated method stub
		return HealthCheckResponse.up("Coffe is up and running.....");
	}

}

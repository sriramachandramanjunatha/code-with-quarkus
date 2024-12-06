package org.acme.microprofile.faulttolerance.resource;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.acme.microprofile.faulttolerance.Coffee;
import org.acme.microprofile.faulttolerance.service.CoffeeRepositoryService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/coffee") public class CoffeeResource {
private static final org.jboss.logging.Logger logger=org.jboss.logging.Logger.getLogger(CoffeeResource.class);
@Inject
CoffeeRepositoryService coffeeRepositoryService;
private AtomicLong counter= new AtomicLong();


@GET
@Retry(maxRetries = 4)
public List<Coffee> coffees(){
	final Long invocationNumber=counter.getAndIncrement();
	faultToleranceTest("CoffeeResource #coffees invocation failed for invocationNumber #%d "+invocationNumber);
	logger.info("CoffeeResource #coffees invocation success for invocationNumber #%d "+invocationNumber);
	return coffeeRepositoryService.getCoffees();
}

private void faultToleranceTest(String message) {
	if(new Random().nextBoolean()) {
		logger.error(message);
		throw new RuntimeException("faultTolerance"+message);
	}
}

@GET
@Path("/{id}/recommendations")
@Timeout(250)
@Fallback(fallbackMethod = "fallbackRecommendations")
public List<Coffee> recommendations(int id){
	long startTime=System.currentTimeMillis();
	final long invocationNumber=counter.getAndIncrement();
	try {
		randomDelay();
		logger.info("CoffeeResource #coffees recommendation success for invocationNumber #%d "+invocationNumber);
		return coffeeRepositoryService.getRecommendations(id);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		logger.errorf("CoffeeResource recommendation for invocationNumber #%d timedout after %d ms", invocationNumber,System.currentTimeMillis()-startTime);
		return null;
	}
	
}

private void randomDelay() throws InterruptedException {
	Thread.sleep(new Random().nextInt(500));
}

public List<Coffee> fallbackRecommendations(int id){
	logger.info("fallback to recommendation");
	//return something as default instead of making api fail/timeout
	return Collections.singletonList(coffeeRepositoryService.getById(id));
}
}

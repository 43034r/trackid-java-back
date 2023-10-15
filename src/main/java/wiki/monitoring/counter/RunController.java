package wiki.monitoring.counter;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@RestController
@ManagedResource
public class RunController {

    private int counter2 = 0;

	private static final String template = "trackid.monitoring.wiki counter %s!";
	private final AtomicLong counter = new AtomicLong();

    @ManagedMetric(description = "Number of requests")
    public int getCounter() {
        return counter2;
    }

    public void incrementCounter() {
        counter2++;
    }

	@GetMapping("/run")
	public Runinfo Runinfo(@RequestParam(value = "name", defaultValue = "for counting") String name) {
		return new Runinfo(counter.incrementAndGet(), String.format(template, name));
    }
}


package wiki.monitoring.counter;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

	private static final String template = "trackid.monitoring.wiki counter %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/run")
	public Runinfo Runinfo(@RequestParam(value = "name", defaultValue = "for counting") String name) {
		return new Runinfo(counter.incrementAndGet(), String.format(template, name));
	}
}

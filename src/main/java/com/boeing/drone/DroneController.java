package com.boeing.drone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drones")
public class DroneController {

	private final DroneRepository repository;
	
	public DroneController(DroneRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public Iterable<Drone> all() {
		return this.repository.findAll();
	}
	
	@PostMapping("")
	public Drone create(@RequestBody Drone drone) {
		return this.repository.save(drone);
	}
	
}

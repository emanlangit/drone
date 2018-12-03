package com.boeing.drone;

import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {this.repository.deleteById(id);}

	@PatchMapping("{id}/{newTitle}")
	public void update(@PathVariable Long id, @PathVariable String newTitle) {
		Drone myDrone = this.repository.findById(id).orElse(new Drone());
		myDrone.setTitle(newTitle);
		this.repository.save(myDrone);
	}

//	@PutMapping("{id}/{newTitle}")
//	public void update(@PathVariable Long id, @PathVariable String newTitle) {
//		Drone myDrone = this.repository.findById(id).orElse(new Drone());
//		myDrone.setTitle(newTitle);
//		this.repository.save(myDrone);
//	}
}

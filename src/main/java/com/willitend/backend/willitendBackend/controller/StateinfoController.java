package com.willitend.backend.willitendBackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willitend.backend.willitendBackend.model.Stateinfo;
import com.willitend.backend.willitendBackend.repository.StateinfoRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/stateinfo")
public class StateinfoController {
	
	@Autowired
	StateinfoRepository stateinfoRepository; 
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Stateinfo>> getAllStateInfo() {
		try {
			List<Stateinfo> statesInfo = new ArrayList<>(); 
			
			stateinfoRepository.findAll().forEach(statesInfo::add);
			
			if (statesInfo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			
			return new ResponseEntity<>(statesInfo, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Stateinfo> createStateInfo(@RequestBody Stateinfo stateinfo) {
		try {
			Stateinfo _stateinfo = stateinfoRepository.save(new Stateinfo(stateinfo.getName(), stateinfo.getHDays(), stateinfo.getFirstShot(), stateinfo.getSecShot(), stateinfo.getVacPerDay(), stateinfo.getHPop(), stateinfo.getPop()));
			return new ResponseEntity<>(_stateinfo, HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PutMapping("/update/{name}")
	public ResponseEntity<Stateinfo> updateStateInfo(@PathVariable("name") String name, @RequestBody Stateinfo stateinfo) {
		Stateinfo stateData = stateinfoRepository.findByName(name);
		
		if (stateData != null) {
			stateData.setHDays(stateinfo.getHDays());
			stateData.setFirstShot(stateinfo.getFirstShot());
			stateData.setSecShot(stateinfo.getSecShot());
			stateData.setVacPerday(stateinfo.getVacPerDay());
			stateData.setHPop(stateinfo.getHPop());
			
			return new ResponseEntity<>(stateinfoRepository.save(stateData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

package com.selenanguyen.dojosandninjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenanguyen.dojosandninjas.Models.Ninja;
import com.selenanguyen.dojosandninjas.Repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;

	
	// =========== Create/Update ================
	public Ninja save(Ninja s) {
		return ninjaRepository.save(s);
	}
	
	// =========== Read ====================
	public List<Ninja> getAll(){
		return ninjaRepository.findAll();
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> s = ninjaRepository.findById(id);
		
		if (s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	// =============== Delete =================
	public void delete(Long id) {
		ninjaRepository.deleteById(id);
	}
}

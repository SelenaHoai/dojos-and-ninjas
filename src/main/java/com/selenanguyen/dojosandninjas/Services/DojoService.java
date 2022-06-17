package com.selenanguyen.dojosandninjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenanguyen.dojosandninjas.Models.Dojo;
import com.selenanguyen.dojosandninjas.Repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	
	// =========== Create/Update ================
	public Dojo save(Dojo s) {
		return dojoRepository.save(s);
	}
	
	// =========== Read ====================
	public List<Dojo> getAll(){
		return dojoRepository.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> s = dojoRepository.findById(id);
		
		if (s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	// =============== Delete =================
	public void delete(Long id) {
		dojoRepository.deleteById(id);
	}

}

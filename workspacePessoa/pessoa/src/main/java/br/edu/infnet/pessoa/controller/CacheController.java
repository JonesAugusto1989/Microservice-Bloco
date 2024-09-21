package br.edu.infnet.pessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pessoa.service.CacheService;

@RestController
@RequestMapping("/")
public class CacheController {
	
	@Autowired
	private CacheService cacheService;
	
	
	@PostMapping("/")
	public void limpa(@RequestParam("cacheName")String cacheName) {
		cacheService.evictAllCacheValues(cacheName);
	}
	
	

}

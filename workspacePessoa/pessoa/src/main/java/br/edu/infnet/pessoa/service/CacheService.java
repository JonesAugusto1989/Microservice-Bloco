package br.edu.infnet.pessoa.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CacheService {
	
	@Autowired
	private CacheManager cacheManager;

	
	
	public void evictAllCacheValues(String cacheName) {
		
		Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
	}
	
}

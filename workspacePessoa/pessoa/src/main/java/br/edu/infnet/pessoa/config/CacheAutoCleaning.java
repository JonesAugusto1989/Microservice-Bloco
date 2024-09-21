package br.edu.infnet.pessoa.config;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.edu.infnet.pessoa.service.PessoaService;

@Component
public class CacheAutoCleaning {
	
	Logger logger = LoggerFactory.getLogger(CacheAutoCleaning.class);
	@Autowired
	private CacheManager cacheManager;
	
	@Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
	@CacheEvict("encomendas")
	public void CacheAutoLimpeza() {
		logger.info("Limpando o Cache de encomendas");
		cacheManager.getCache("encomendas").clear();
	}

}

package com.foreign.common.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.foreign.common.service.EnviromentService;

@Service
public class EnviromentServiceImpl implements EnviromentService {

	private boolean devMode = false;

	@PostConstruct
	public void init() {
		devMode = false;
	}

	@Override
	public boolean isDevMode() {
		return devMode;
	}

}

package com.ticketsMgrSysWayClient_8522.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketsMgrSysWayClient_8522.feignClientService.RouteFeignService;

@Controller
public class IndexController {
	@Resource
	private RouteFeignService routeFeignService;

	@RequestMapping({"","/","/getWay"})
	public String getWay() {
		return "index";
	}

}

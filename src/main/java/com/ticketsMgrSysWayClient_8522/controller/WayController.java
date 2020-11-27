package com.ticketsMgrSysWayClient_8522.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketsMgrSysWayClient_8522.feignClientService.RouteFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.RouteInfo;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.Station;

@Controller
@RequestMapping("/way")
public class WayController {
	@Resource
	private RouteFeignService routeFeignService;

	@RequestMapping("/index")
	public String getWay(@PathVariable int wayId) {
		return "index";
	}
	@RequestMapping("/show")
	public String showWay(ModelMap mm) {
		mm.addAttribute("routes",routeFeignService.getRoutes() );
		return "showWays";
	}
	@RequestMapping("/add")
	public String add(ModelMap mm) {
		Map<String, List<Station>> map=routeFeignService.getStations();
		List<Station> list=new ArrayList<>();
		for(List<Station> stations : map.values()){
			for(Station station:stations) {
				list.add(station);
			}
		}
		mm.addAttribute("stations", list);
		return "addWay";
	}
	
	@RequestMapping("/addRoute")
	public String addWay( RouteInfo route) {
		if(routeFeignService.addRoute(route)){
			return "redirect:/way/show";
		}else {
			return "addWay";
		}
	}
	@RequestMapping("/getRouteById/{routeId}")
	public String getRouteById(ModelMap mm,@PathVariable int routeId) {
		mm.addAttribute("route",routeFeignService.getRouteById(routeId));
		
		Map<String, List<Station>> map=routeFeignService.getStations();
		List<Station> list=new ArrayList<>();
		for(List<Station> stations : map.values()){
			for(Station station:stations) {
				list.add(station);
			}
		}
		mm.addAttribute("stations", list);
		return "modifyWay";
	}
	
	@RequestMapping("/modifyRoute")
	public String modifyRoute(RouteInfo route,ModelMap mm) {
		boolean falg = routeFeignService.modifyRoute(route);
		if(falg) {
			return "redirect:/way/show";
		}else {
			return "forward:/way/getRouteById/"+route.getRouteId();
		}
	}
	
	@RequestMapping("/removeRouteById/{routeId}")
	public String removeRouteById(@PathVariable int routeId) {
		if(routeFeignService.removeRouteById(routeId)) {
			return "redirect:/way/show";
		}else {
			return "redirect:/way/show";
		}
	}
}

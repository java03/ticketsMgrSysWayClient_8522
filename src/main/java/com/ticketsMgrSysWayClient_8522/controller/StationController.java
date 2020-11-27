package com.ticketsMgrSysWayClient_8522.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketsMgrSysWayClient_8522.feignClientService.RouteFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.Station;

@Controller
@RequestMapping("/station")
public class StationController {
	@Resource
	private RouteFeignService stationService;

	
	@RequestMapping("/show")
	public String showStation(ModelMap mm) {
		Map<String, List<Station>> map=stationService.getStations();
//		List<Station> list=new ArrayList<>();
//		for(List<Station> stations : map.values()){
//			for(Station station:stations) {
//				list.add(station);
//			}
//		}
//		mm.addAttribute("stations", list);
		mm.addAttribute("stMap", map);
		return "showStation";
	}
	@RequestMapping("/add")
	public String add() {
		return "addStation";
	}
	@RequestMapping("/addStation")
	public String addStation(Station station) {
		if(stationService.addStation(station)){
			return "redirect:/station/show";
		}else {
			return "redirect:/station/show";
		}
	}
	
	
	@RequestMapping("/modifyStation")
	public String modifyStation(Station station) {
		if(stationService.modifyStation(station)){
			return "redirect:/station/show";
		}else {
			return "modifyStation";
		}
	}
	
	@RequestMapping("/getStationById/{stationId}")
	public String getStationById(ModelMap mm,@PathVariable int stationId) {
		mm.addAttribute("station",stationService.getStationById(stationId));
		return "modifyStation";
	}
	
	@RequestMapping("/removeStation/{stationId}")
	public String removeStation(@PathVariable int stationId) {
		if(stationService.removeStation(stationId)) {
			return "redirect:/station/show";
		}else {
			return "redirect:/station/show";
		}
	}

	
}

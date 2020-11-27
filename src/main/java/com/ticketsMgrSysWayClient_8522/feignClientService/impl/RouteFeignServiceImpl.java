package com.ticketsMgrSysWayClient_8522.feignClientService.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketsMgrSysWayClient_8522.feignClientService.RouteFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.RouteInfo;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.Station;
@Component
public class RouteFeignServiceImpl implements RouteFeignService{

	@Override
	@RequestMapping("/way/getRoutes")
	public List<RouteInfo> getRoutes() {
		return null;
	}

	@Override
	@RequestMapping("/way/getRouteById/{routeId}")
	public RouteInfo getRouteById(int routeId) {
		return null;
	}

	@Override
	@RequestMapping("/station/getStations")
	public Map<String, List<Station>> getStations() {
		return null;
	}

	@Override
	@RequestMapping("/station/addStation")
	public boolean addStation(Station station) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Station getStationById(int stationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("/station/modifyStation")
	public boolean modifyStation(Station station) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/station/removeStation/{stationId}")
	public boolean removeStation(int stationId) {
		return false;
	}

	@Override
	@RequestMapping("/way/removeRouteById/{routeId}")
	public boolean removeRouteById(int routeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/way/modifyRoute")
	public boolean modifyRoute(RouteInfo route) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/way/addRoute")
	public boolean addRoute(RouteInfo route) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

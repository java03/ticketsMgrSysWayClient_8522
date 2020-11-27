package com.ticketsMgrSysWayClient_8522.feignClientService;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketsMgrSysWayClient_8522.feignClientService.impl.RouteFeignServiceImpl;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.RouteInfo;
import com.yueqian.ticketsMgr_domain_9000.domain.wayMgr.Station;

@FeignClient(name="way-service",path= "/sysWayProvider",fallback=RouteFeignServiceImpl.class)
public interface RouteFeignService {
	/**
	 * 获取所有线路
	 */
	@RequestMapping("/way/getRoutes")
	public List<RouteInfo> getRoutes();
	
	/**
	 * 获取指定线路
	 */
	@RequestMapping("/way/getRouteById/{routeId}")
	public RouteInfo getRouteById(@PathVariable int routeId);
	/**
	 * 修改线路
	 */
	@RequestMapping("/way/modifyRoute")
	public boolean modifyRoute(@RequestBody RouteInfo route);
	/**
	 * 添加线路
	 */
	@RequestMapping("/way/addRoute")
	public boolean addRoute(@RequestBody RouteInfo route);
	/**
	 * 删除指定线路
	 */
	@RequestMapping("/way/removeRouteById/{routeId}")
	public boolean removeRouteById(@PathVariable int routeId);
	
	/**
	 * 获取所有站点
	 */
	@RequestMapping("/station/getStations")
	public Map<String, List<Station>> getStations();
	
	/**
	 * 添加站点
	 */
	@RequestMapping("/station/addStation")
	public boolean addStation(@RequestBody Station station);
	
	/**
	 * 获取指定站点
	 */
	@RequestMapping("/station/getStation/{stationId}")
	public Station getStationById(@PathVariable int stationId);
	
	/**
	 * 修改站点
	 */
	@RequestMapping("/station/modifyStation")
	public boolean modifyStation(@RequestBody Station station);
	
	/**
	 * 删除站点
	 */
	@RequestMapping("/station/removeStation/{stationId}")
	public boolean removeStation(@PathVariable int stationId);
}

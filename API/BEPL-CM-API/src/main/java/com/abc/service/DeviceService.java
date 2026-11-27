package com.abc.service;

import java.util.List;
import com.abc.model.Device;

public interface DeviceService
{

	public List<Device> getAllDevice();
	
	public Device getDeviceById(String ip_address);
	
	public List<Device> getAllDeviceBySite(String site);
	
	public Device Save(Device device);
	
	public List<Device> SaveAll(List<Device> device);
	
	public void delete(String ip_address);

}
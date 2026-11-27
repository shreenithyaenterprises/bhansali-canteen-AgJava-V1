package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.Device;
import com.abc.repository.DeviceRepository;
import com.abc.service.DeviceService;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService
{

	@Autowired
	DeviceRepository repo;
	
	@Override
	public List<Device> getAllDevice()
	{
		return (List<Device>) repo.findAll();
	}
	@Override
	public List<Device> getAllDeviceBySite(String site)
	{
		return (List<Device>) repo.findAllBySiteCode(site);
	}
	@Override
	public Device getDeviceById(String ip_address)
	{
		return repo.findById(ip_address).get();
	}
	@Override
	public Device Save(Device device)
	{
		return repo.save(device);
	}
	@Override
	public List<Device> SaveAll(List<Device> device)
	{
		return (List<Device>) repo.saveAll(device);
	}
	@Override
	public void delete(String ip_address)
	{
		 repo.deleteById(ip_address);
	}
}

package com.abc.service;

import java.util.List;
import com.abc.model.EstablishmentMaster;

public interface EstablishmentMasterService
{

	public List<EstablishmentMaster> getAllEstablishmentMaster();
	
	public EstablishmentMaster getEstablishmentMasterById(String code);
	
	public EstablishmentMaster Save(EstablishmentMaster establishmentmaster);
	
	public List<EstablishmentMaster> SaveAll(List<EstablishmentMaster> establishmentmaster);
	
	public void delete(String code);

}
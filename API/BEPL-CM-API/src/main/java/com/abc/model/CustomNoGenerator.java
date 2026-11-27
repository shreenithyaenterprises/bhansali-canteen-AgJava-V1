package com.abc.model;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.*;
import org.hibernate.engine.spi.*;
import org.hibernate.id.*;

public class CustomNoGenerator implements IdentifierGenerator
{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddMMmmss");
			return simpleDateFormat.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.curso.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.curso.domain.Tramite;
import com.curso.dao.TramiteDaoImpl;
import com.curso.idao.ITramiteDao;
import java.util.List;



public class Test {

	public static void main(String[] args) {

		ITramiteDao tramiteService = new TramiteDaoImpl();
		pruebaConsultWithCriteria(tramiteService,"UDEMY2");

	}
	
	public static void pruebaConsultWithCriteria(ITramiteDao tramiteService, String description) {
		List<Tramite> listTramite = tramiteService.consultWithCriteria(description);
		
		for(Tramite tramite : listTramite) {
			System.out.println(tramite.toString());
		}
		
	}

}

package com.curso.test;

import java.sql.Timestamp;
import java.util.Date;

import com.curso.domain.Tramite;
import com.curso.dao.TramiteDaoImpl;
import com.curso.idao.ITramiteDao;

public class Test {

	public static void main(String[] args) {

		ITramiteDao tramiteService = new TramiteDaoImpl();

		Tramite tramite = new Tramite();
		//Date date = new Date();

		//tramite.setFhcTram(new Timestamp(date.getTime()));
		//tramite .setTipoTram("UDEMY4");

		//tramiteService.save(tramite);
		Tramite tramiteResult = tramiteService.loadTramite("Prueba");
		System.out.println("Resultado: "+ tramiteResult.toString());
		tramiteService.delete(tramiteResult);

	}

}

package com.curso.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.curso.domain.Avaluo;
import com.curso.domain.Tramite;
import com.curso.dao.AvaluoDaoImpl;
import com.curso.dao.TramiteDaoImpl;
import com.curso.idao.IAvaluoDao;
import com.curso.idao.ITramiteDao;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		ITramiteDao tramiteService = new TramiteDaoImpl();
		IAvaluoDao avaluoService = new AvaluoDaoImpl();
//		pruebaConsultWithCriteria(tramiteService,"UDEMY2");
//		pruebaConsultWithCriteria(tramiteService);
//		pruebaConsultWithCriteriaCustom(tramiteService,"UDEMY2");
//		pruebaInsertAvaluo( tramiteService, avaluoService);
//		pruebaUpdateAvaluo( avaluoService);		
//		pruebaConsulAvaluotWithCreateQuery(avaluoService,"Guatire");
//		pruebaAvaluoConsultWithCriteria(avaluoService);
//		pruebaAvaluoConsultWithCriteriaCustom(avaluoService,"Bogota");
//		pruebaSaveOneToOne(tramiteService,avaluoService);
//		 pruebaConsultAvaluoGetTramite(avaluoService);
//		 pruebaConsultAvaluoGetAllTramite(avaluoService);
		pruebaConsultTramiteGetAvaluo(tramiteService);

	}

	public static void pruebaConsultWithCreateQuery(ITramiteDao tramiteService, String description) {
		List<Tramite> listTramite = tramiteService.consultWithCreateQuery(description);

		for (Tramite tramite : listTramite) {
			System.out.println(tramite.toString());
		}

	}

	public static void pruebaConsultWithCriteria(ITramiteDao tramiteService) {
		List<Tramite> listTramite = tramiteService.consultWithCriteria();

		for (Tramite tramite : listTramite) {
			System.out.println(tramite.toString());
		}

	}

	public static void pruebaConsultWithCriteriaCustom(ITramiteDao tramiteService, String description) {
		List<Tramite> listTramite = tramiteService.consultWithCriteriaCustom(description);

		for (Tramite tramite : listTramite) {
			System.out.println(tramite.toString());
		}

	}

	public static void pruebaInsertAvaluo(ITramiteDao tramiteService, IAvaluoDao avaluoService) {

		Tramite tramite = tramiteService.loadTramite("UDEMY");
		Avaluo aval = new Avaluo();

		aval.setLugarAval("Guatire");
		aval.setTramite(tramite);

		avaluoService.save(aval);
		System.out.println("Registro salvado: " + aval.toString());

	}

	public static void pruebaUpdateAvaluo(IAvaluoDao avaluoService) {

		Avaluo aval = new Avaluo();
		aval = avaluoService.loadAvaluo("Caracas");
		aval.setLugarAval("Guatire");
		Avaluo aval2 = aval;
		avaluoService.update(aval2);
		System.out.println("Registro actualizado: " + aval.toString());

	}

	public static void pruebaConsulAvaluotWithCreateQuery(IAvaluoDao avaluoService, String lugar) {
		List<Avaluo> listAvaluo = avaluoService.consultWithCreateQuery(lugar);

		for (Avaluo avaluo : listAvaluo) {
			System.out.println(avaluo.toString());
		}

	}

	public static void pruebaAvaluoConsultWithCriteria(IAvaluoDao avaluoService) {
		List<Avaluo> listAvaluo = avaluoService.consultWithCriteria();

		for (Avaluo avaluo : listAvaluo) {
			System.out.println(avaluo.toString());
		}

	}

	public static void pruebaAvaluoConsultWithCriteriaCustom(IAvaluoDao avaluoService, String description) {
		List<Avaluo> listAvaluo = avaluoService.consultWithCriteriaCustom(description);

		for (Avaluo avaluo : listAvaluo) {
			System.out.println(avaluo.toString());
		}

	}

	public static void pruebaSaveOneToOne(ITramiteDao tramiteService, IAvaluoDao avaluoService) {
		Date date = new Date();

		Tramite tramite = new Tramite("Prueba OneToOne", new Timestamp(date.getTime()));

		tramiteService.save(tramite);

		Avaluo avaluo = new Avaluo("Bogota");
		avaluo.setTramite(tramite);

		avaluoService.save(avaluo);
	}

	public static void pruebaConsultAvaluoGetTramite(IAvaluoDao avaluoService) {

		Avaluo aval = avaluoService.loadAvaluo(2);
		Tramite tramite = aval.getTramite();

		System.out.println("Para el avaluo - " + aval.getIdAval() + " el tramite es - " + tramite.toString());
	}

	public static void pruebaConsultAvaluoGetAllTramite(IAvaluoDao avaluoService) {

		List<Avaluo> listAvaluo = avaluoService.consultAllAvaluoGetTramite();

		for (Avaluo avaluo : listAvaluo) {
			System.out.println(
					"Para el avaluo: " + avaluo.getIdAval() + " el tramite es: " + avaluo.getTramite().getTipoTram());
		}

	}

	public static void pruebaConsultTramiteGetAvaluo(ITramiteDao tramiteService) {
		tramiteService.loadTramite(9);

	}

}

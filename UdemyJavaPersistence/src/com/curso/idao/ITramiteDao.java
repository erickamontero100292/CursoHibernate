package com.curso.idao;

import com.curso.domain.Tramite;

public interface ITramiteDao {
	
	void save (Tramite tramite);
	
	void update(Tramite tramite);
	
	void saveOrUpdate(Tramite tramite);
	
	void delete();
	
	Tramite loadTramite(Tramite tramite);

}

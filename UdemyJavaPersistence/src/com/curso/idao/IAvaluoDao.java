package com.curso.idao;

import java.util.List;

import com.curso.domain.Avaluo;

public interface IAvaluoDao {
	
	void save(Avaluo avaluo);

	void update(Avaluo avaluo);

	void saveOrUpdate(Avaluo avaluo);

	void delete(Avaluo avaluo);

	Avaluo loadAvaluo(Avaluo avaluo);

	Avaluo loadAvaluo(String descriptionAvaluo);

	List<Avaluo> consultWithCreateQuery(String descriptionAvaluo);

	List<Avaluo> consultWithCriteria();

	List<Avaluo> consultWithCriteriaCustom(String descriptionAvaluo);
}

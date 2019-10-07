package com.xy.teste.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.xy.teste.entities.Place;

@Repository
public class PlaceDAO implements IPlaceDAO {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Place> getPlaces() {
	    Query query = em.createQuery("SELECT p FROM Place p");
		return (Collection<Place>) query.getResultList();
	}

	@Override
	@Transactional
	public void insertPlace(Place place) {
		// TODO Auto-generated method stub
		em.persist(place);
	}

}

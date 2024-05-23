package com.iktobuka.data_access.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktobuka.data_access.entities.AddressEntity;
import com.iktobuka.data_access.repositories.AddressRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	protected AddressRepository addressRepository;

	@Override
	public List<AddressEntity> findAddressesByUserNameDao(String name) {

		String sql = "select a " + 
					 "from AddressEntity a " + 
					 "left join fetch a.users u " + 
					 "where u.name = :name ";

		Query query = em.createQuery(sql);
		query.setParameter("name", name);

		List<AddressEntity> result = new ArrayList<>();
		result = query.getResultList();

		return result;
	}

	@Override
	public Iterable<AddressEntity> findAllDao() {
		return addressRepository.findAll();
	}

	@Override
	public AddressEntity createAddressDao(
			String street, 
			String city, 
			String country
		) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		
		addressRepository.save(address);
		
		return address;
	}
}

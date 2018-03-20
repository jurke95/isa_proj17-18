package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Offer;
import com.ISA.ISA_Project.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;

	public OfferService() {

	}

	public List<Offer> getAllOffers() {

		return offerRepository.findAll();
	}

	public void deleteOffer(Long id) {

		offerRepository.delete(id);

	}

	public void saveOffer(Offer offer) {

		offerRepository.save(offer);
	}

}

package com.iktobuka.project_web_app.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.project_web_app.entities.OfferEntity;
import com.iktobuka.project_web_app.entities.OfferEntity.OfferStatus;

@RestController
@RequestMapping(path = "/project/offers")
public class OfferController {

	public List<OfferEntity> getDB() {
		List<OfferEntity> offers = new ArrayList<>();

		// Offer 1
		LocalDate offerCreated1 = LocalDate.of(2024, 4, 1);
		LocalDate offerExpires1 = LocalDate.of(2024, 4, 30);
		offers.add(new OfferEntity(1, "Discount on Guitars", "Get 20% off on all guitars!", offerCreated1,
				offerExpires1, 1000.0, 800.0, "/images/guitar_discount.jpg", 50, 20, OfferStatus.EXPIRED));

		// Offer 2
		LocalDate offerCreated2 = LocalDate.of(2024, 5, 1);
		LocalDate offerExpires2 = LocalDate.of(2024, 5, 31);
		offers.add(new OfferEntity(2, "Drum Set Sale", "Limited time offer: buy one get one free!", offerCreated2,
				offerExpires2, 1500.0, 1000.0, "/images/drum_set_sale.jpg", 30, 10, OfferStatus.APPROVED));

		// Offer 3
		LocalDate offerCreated3 = LocalDate.of(2024, 3, 1);
		LocalDate offerExpires3 = LocalDate.of(2024, 6, 30);
		offers.add(new OfferEntity(3, "Keyboard Clearance Sale", "Last chance to buy keyboards at discounted prices!",
				offerCreated3, offerExpires3, 1200.0, 900.0, "/images/keyboard_sale.jpg", 20, 5, OfferStatus.APPROVED));

		// Offer 4
		LocalDate offerCreated4 = LocalDate.of(2024, 4, 1);
		LocalDate offerExpires4 = LocalDate.of(2024, 8, 31);
		offers.add(new OfferEntity(4, "Microphone Bundle Deal", "Buy one microphone, get one free!", offerCreated4,
				offerExpires4, 500.0, 400.0, "/images/microphone_deal.jpg", 40, 15, OfferStatus.APPROVED));

		// Offer 5
		LocalDate offerCreated5 = LocalDate.of(2024, 3, 1);
		LocalDate offerExpires5 = LocalDate.of(2024, 9, 30);
		offers.add(new OfferEntity(5, "Guitar Strings Promotion",
				"Purchase a set of guitar strings and get a free tuner!", offerCreated5, offerExpires5, 50.0, 40.0,
				"/images/guitar_strings_promo.jpg", 100, 80, OfferStatus.APPROVED));

		// Offer 6
		LocalDate offerCreated6 = LocalDate.of(2024, 2, 1);
		LocalDate offerExpires6 = LocalDate.of(2024, 8, 31);
		offers.add(new OfferEntity(6, "Studio Monitor Clearance",
				"Limited stock available! Get studio monitors at a discounted price!", offerCreated6, offerExpires6,
				800.0, 600.0, "/images/studio_monitor_clearance.jpg", 15, 5, OfferStatus.DECLINED));

		// Offer 7
		LocalDate offerCreated7 = LocalDate.of(2024, 7, 1);
		LocalDate offerExpires7 = LocalDate.of(2024, 11, 30);
		offers.add(new OfferEntity(7, "DJ Mixer Sale", "Upgrade your DJ setup with our discounted mixers!",
				offerCreated7, offerExpires7, 1000.0, 750.0, "/images/dj_mixer_sale.jpg", 25, 0,
				OfferStatus.WAIT_FOR_APPROVING));

		// Offer 8
		LocalDate offerCreated8 = LocalDate.of(2024, 8, 1);
		LocalDate offerExpires8 = LocalDate.of(2024, 12, 31);
		offers.add(new OfferEntity(8, "Live Sound System Bundle",
				"Complete your live sound setup with our bundle offer!", offerCreated8, offerExpires8, 2000.0, 1500.0,
				"/images/live_sound_bundle.jpg", 10, 0, OfferStatus.WAIT_FOR_APPROVING));

		// Offer 9
		LocalDate offerCreated9 = LocalDate.of(2025, 1, 1);
		LocalDate offerExpires9 = LocalDate.of(2025, 1, 31);
		offers.add(new OfferEntity(9, "Recording Software Promotion", "Special offer on recording software!",
				offerCreated9, offerExpires9, 300.0, 200.0, "/images/recording_software_promo.jpg", 50, 0,
				OfferStatus.WAIT_FOR_APPROVING));

		// Offer 10
		LocalDate offerCreated10 = LocalDate.of(2025, 2, 1);
		LocalDate offerExpires10 = LocalDate.of(2025, 2, 28);
		offers.add(new OfferEntity(10, "Music Books Clearance", "Get music books at discounted prices!", offerCreated10,
				offerExpires10, 20.0, 15.0, "/images/music_books_clearance.jpg", 200, 0,
				OfferStatus.WAIT_FOR_APPROVING));

		return offers;
	}

	List<OfferEntity> offers = getDB();

	@GetMapping
	public List<OfferEntity> getAllOffers() {
		return offers;
	}

	@PostMapping
	public OfferEntity addOffer(@RequestBody OfferEntity offer) {
		return offer;
	}

	private OfferEntity findOfferById(int id) {
		for (OfferEntity offer : offers) {
			if (offer.getId() == id) {
				return offer;
			}
		}
		System.out.println("No offer with id " + id);

		return null;
	}

	@PutMapping("/{id}")
	public OfferEntity updateOffer(@PathVariable int id, @RequestBody OfferEntity updatedOffer) {
		OfferEntity existingOffer = findOfferById(id);

		if (existingOffer == null || existingOffer.getId() != id) {
			return null;
		}

		existingOffer.setOfferName(updatedOffer.getOfferName());
		existingOffer.setOfferDescription(updatedOffer.getOfferDescription());
		existingOffer.setOfferCreated(updatedOffer.getOfferCreated());
		existingOffer.setOfferExpires(updatedOffer.getOfferExpires());
		existingOffer.setRegularPrice(updatedOffer.getRegularPrice());
		existingOffer.setActionPrice(updatedOffer.getActionPrice());
		existingOffer.setImagePath(updatedOffer.getImagePath());
		existingOffer.setAvailableOffers(updatedOffer.getAvailableOffers());
		existingOffer.setBoughtOffers(updatedOffer.getBoughtOffers());

		return existingOffer;
	}
}

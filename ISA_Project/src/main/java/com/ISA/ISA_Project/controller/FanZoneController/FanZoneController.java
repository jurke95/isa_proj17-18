package com.ISA.ISA_Project.controller.FanZoneController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.FanZoneController.dto.AdDTO;
import com.ISA.ISA_Project.controller.FanZoneController.dto.ProductDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Offer;
import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.FanZoneRepository;
import com.ISA.ISA_Project.response.AdResponse;
import com.ISA.ISA_Project.response.ProductResponse;
import com.ISA.ISA_Project.service.AdService;
import com.ISA.ISA_Project.service.EmailService;
import com.ISA.ISA_Project.service.OfferService;
import com.ISA.ISA_Project.service.ProductService;
import com.ISA.ISA_Project.service.ReservationService;
import com.ISA.ISA_Project.service.UserService;

@RestController
@RequestMapping("/fanzone")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class FanZoneController {

	@Autowired
	private FanZoneRepository fanzoneRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private AdService adService;

	@Autowired
	private UserService userService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private OfferService offerService;
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/getProducts")
	public ProductResponse getProducts() {

		List<Product> listp = productService.getAllItems();
		return new ProductResponse(listp);

	}

	@GetMapping("/getAds")
	public AdResponse getAds() {

		List<Ad> lista = adService.getAllItems();
		return new AdResponse(lista);

	}

	@GetMapping("getProducts/{id}")
	public Product getProduct(@PathVariable("id") Long id) {

		Product product = productService.getProduct(id);
		return product;
	}

	@GetMapping("getAds/{id}")
	public Ad getAds(@PathVariable("id") Long id) {

		Ad ad = adService.getAd(id);
		return ad;
	}

	@PostMapping("/addProducts")
	public MessageResponseDTO addProduct(@RequestBody ProductDTO productDTO) {

		Product p = new Product();
		/*
		if (!(productService.checkUniqueProduct(productDTO.getId()))) {
			return new MessageResponseDTO("This product already exists");
		}
        */
		p.setName(productDTO.getName());
		p.setDescription(productDTO.getDescription());
		p.setImage(productDTO.getImage());
		p.setBoxoffice(productDTO.getBoxoffice());
		p.setPrice(productDTO.getPrice());

		Product temp = productService.saveProduct(p);

		if (temp == null)
			return new MessageResponseDTO("Cannot add product,check out input parameters!");

		return new MessageResponseDTO("Successfully added product!");
	}

	@PostMapping("/addAd")
	public MessageResponseDTO addAd(@RequestBody AdDTO adDTO, @RequestParam("userId") String userId) {
       System.out.println(adDTO.getDate());
		Ad a = new Ad();
		/*
		if (!(adService.checkUniqueAd(adDTO.getId()))) {
			return new MessageResponseDTO("This ad already exists");
		}
*/
		Long u = Long.parseLong(userId);
		a.setAdmaker(userService.findOneUserById(u));
		a.setName(adDTO.getName());
		a.setDescription(adDTO.getDescription());
		a.setImage(adDTO.getImage());
		a.setDate(adDTO.getDate());
		a.setAccepted(false);

		// fali deo za slanje oglasa na odobrenje Administratoru
		// takodje deo za ponude PONUDJIVAC-OGLAS (many-to-many relationship)
		Ad temp = adService.saveAd(a);

		if (temp == null)
			return new MessageResponseDTO("Cannot add ad, check out input parameters!");

		return new MessageResponseDTO("Successfully added ad!");
	}

	@PostMapping("/editProduct/{id}")
	public MessageResponseDTO editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {

		Product p = new Product();
/*
		if ((productService.checkUniqueProduct(productDTO.getId()))) {
			return new MessageResponseDTO("You cannot edit non-existing product");
		}
*/
		p.setId(id);
		p.setName(productDTO.getName());
		p.setDescription(productDTO.getDescription());
		p.setImage(productDTO.getImage());
		p.setBoxoffice(productDTO.getBoxoffice());
		p.setPrice(productDTO.getPrice());

		Product temp = productService.saveProduct(p);

		if (temp == null)
			return new MessageResponseDTO("Cannot edit product,check out input parameters!");

		return new MessageResponseDTO("Successfully edited product!");
	}

	@PostMapping("/editAd/{id}")
	public MessageResponseDTO editAd(@RequestBody AdDTO adDTO, @PathVariable("id") Long id) {

		Ad a = new Ad();

		/*
		if ((adService.checkUniqueAd(adDTO.getId()))) {
			return new MessageResponseDTO("You cannot edit non-existing ad");
		}
*/
		a.setId(id);
		a.setName(adDTO.getName());
		a.setDescription(adDTO.getDescription());
		a.setImage(adDTO.getImage());
		a.setDate(adDTO.getDate());

		Ad temp = adService.saveAd(a);

		if (temp == null)
			return new MessageResponseDTO("Cannot edit ad,check out input parameters!");

		return new MessageResponseDTO("Successfully edited ad!");
	}

	@DeleteMapping("/deleteProducts/{id}")
	public MessageResponseDTO deleteProducts(@PathVariable("id") Long id) {
    
		productService.deleteProduct(id);

		return new MessageResponseDTO("Successfully deleted product");
	}

	@DeleteMapping("/deleteAds/{id}")
	public MessageResponseDTO deleteAds(@PathVariable("id") Long id) {
		
		List<Offer>listOffers =offerService.getAllOffersByAd(adService.getAd(id));

		int x=offerService.getAllOffersByAd(adService.getAd(id)).size();
		if (x!=0){
			
			for(int i=0;i<x;i++){
				offerService.deleteOffer(listOffers.get(i).getId());
				
			}
		}
		
		
		adService.deleteAd(id);

		return new MessageResponseDTO("Successfully deleted ad");
	}

	@PostMapping("/reservationProduct")
	public MessageResponseDTO reservationProduct(@RequestParam("userId") String userId,
			@RequestParam("productId") String productId /*,
			@RequestParam(value = "checkboxName", required = false) String checkboxValue*/) {
/*
		if (checkboxValue != null) {
			// System.out.println("checkbox is checked");
		} else {
			// System.out.println("checkbox is not checked");
		}
		// necemo raditi zabranu rezervacije istog rekvizita od drugog korisnika( u
		// slucaju da je vec prethodno rezervisan) u back-endu
		// vec cemo tu zabranu odraditi na u front -endu jednostavno cemo posle
		// rezervacije onemoguciti dalji klik na dugme rezervisi za taj rekvizit
*/
		Long prod = Long.parseLong(productId);
		Long u = Long.parseLong(userId);
		
		productService.getProduct(prod).setBuyer(userService.findOneUserById(u));

		productService.saveProduct(productService.getProduct(prod));
		User customer=userService.findOneUserById(u);
		
		SimpleMailMessage registrationEmail=new SimpleMailMessage();
		registrationEmail.setTo(customer.getEmail());
		registrationEmail.setSubject("Product reservation mail");
		registrationEmail.setText("You have successfully reserved the product below:\n"
		+"Product name  "+productService.getProduct(prod).getName()+"\n"
		+"Product description  "+productService.getProduct(prod).getDescription()+"\n"
		+"Product price  "+productService.getProduct(prod).getPrice()+"\n"
		+"Product location  "+productService.getProduct(prod).getBoxoffice()+"\n");
		
		emailService.sendEmail(registrationEmail);

		return new MessageResponseDTO("Successfully reservation! Check out your e-mail for details!");
	}

	@DeleteMapping("/deleteReservation/{id}")
	public MessageResponseDTO deleteReservation(@PathVariable("id") Long id) {

		reservationService.deleteReservation(id);

		return new MessageResponseDTO("Successfully deleted reservation");
	}

	@PostMapping("/makeOffer/{id}")
	public MessageResponseDTO makeOffer(@PathVariable("id") Long id, @RequestParam("userId") String userId,
			@RequestParam("offer") String offer) {
		 boolean imaponude=false;
		
		Long o = Long.parseLong(offer); // Koliko nudi para
		Long u = Long.parseLong(userId); // Ko nudi

		List<Offer>offersforad=offerService.getAllOffersByAd(adService.getAd(id));
		
		for(int i=0;i<offersforad.size();i++){
			
			if(offersforad.get(i).getBidder().getId()==u){
				imaponude=true;
				Offer foredit=offersforad.get(i);
				foredit.setBid(o);
				offerService.saveOffer(foredit);
			}
				
		}
		
		if(imaponude==false){
		User bidder = userService.findOneUserById(u);
		Offer offer_new = new Offer();
		offer_new.setBidder(bidder);
		offer_new.setBid(o);
		offer_new.setAd(adService.getAd(id));

		offerService.saveOffer(offer_new);
		}
			
			
			
			
			
			
			
			
		
		

		return new MessageResponseDTO("Successfully made offer for selected ad!");

	}

	@PostMapping("/acceptTheOffer/{id}")
	public MessageResponseDTO acceptTheOffer(@PathVariable("id") Long id, @RequestParam("userId") String userId) {
		// id je od oglasa
		Long u = Long.parseLong(userId); // Ko je poslao tu ponudu
		User winner = userService.findOneUserById(u);
		Ad ad = adService.getAd(id);
		User user = ad.getAdmaker();
		userService.aceptTheOffer(user, winner, ad);
		return new MessageResponseDTO("Successfully send mail for offer");
	}

	@PostMapping("/editOffer/{id}")
	public MessageResponseDTO editOffer(@PathVariable("id") Long id, @RequestParam("bid") String bid) {
		Long b = Long.parseLong(bid);
		Offer offer = offerService.findOfferbyId(id);
		offer.setBid(b);
		offerService.saveOffer(offer);

		return new MessageResponseDTO("Successfully changed the offer");
	}
	
	@PostMapping("/acceptAd/{id}")
	public MessageResponseDTO acceptAd(@PathVariable("id") Long id){
		
		Ad ad=adService.getAd(id);
		ad.setAccepted(true);
		adService.saveAd(ad);
		return new MessageResponseDTO("Successfully accepted ad");
	}
	
	@PostMapping("/editBid/{id}")
	public MessageResponseDTO editBid(@PathVariable("id") Long id, @RequestParam("bid") Long bid){
		Long idUser = userService.activeUser.getId();
		Ad ad=adService.getAd(id);
		List<Offer> offerList=offerService.getAllOffersByAd(ad);
		for(Offer temp : offerList) {
			if(temp.getBidder().getId()==idUser) {
				temp.setBid(bid);
			}
		}
		return new MessageResponseDTO("Successfully edited bid");
	}

	@GetMapping("/getOffer/{id}")
	public Offer getOffer(@PathVariable("id") Long id) {
		return offerService.findOfferbyId(id);
	}

	@GetMapping("/getAllOffers")
	public List<Offer> getAllOffers() {
		return offerService.getAllOffers();
	}

	@GetMapping("/getOffersForAd/{id}") //id oglasa(Ad)
	public List<Offer> getOffersForAd(@PathVariable("id") Long id) {
		Ad ad = adService.getAd(id);

		return offerService.getAllOffersByAd(ad);
	}

}

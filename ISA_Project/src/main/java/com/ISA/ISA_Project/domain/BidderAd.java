package com.ISA.ISA_Project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class BidderAd implements Serializable {

	/*@ManyToOne
	@MapsId("ad_id") // This is the name of attr in EmployerDeliveryAgentPK class
	@JoinColumn(name = "AD_ID")
	private Ad ad;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "BIDDER_ID")
	private User bidder;
*/
}

package org.decentraliseddonations


import grails.rest.*

@Resource(uri = '/api/proposaldonationinfo',readOnly = true, formats = ['json', 'xml'])
class ProposalDonationInfo {

	String proposalName
	String proposalUrl
	Double dashAmountRequested 
	Double donationSofttarget
	Double dashAlreadyReceivedToAddress=0
	String dashAddress
	Double indicatedDashDonationAmountByPotentialDonors
	Double currentAmountDonated=0
	Date donationPeriodStartDate
	Date donationPeriodEndDate 
	Boolean isPastDonation=false

	public Double getPercentageDonatedOfRequested() {

		if(dashAmountRequested && currentAmountDonated!=null) {
			return ((currentAmountDonated/dashAmountRequested)*100).round(2)
		}
		else
			return 0
	}

	public Double getPercentageDonatedOfSoft() {

		if(donationSofttarget && currentAmountDonated!=null) {
			return ((currentAmountDonated/donationSofttarget)*100).round(2)
		}
		else
			return 0
	}

}

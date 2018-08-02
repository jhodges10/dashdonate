package decentraliseddonations
import grails.util.Environment
import org.decentraliseddonations.*


class BootStrap {

    def init = { servletContext ->

    



	switch (Environment.current) {
    case Environment.DEVELOPMENT:
    case Environment.PRODUCTION:

		new ProposalDonationInfo(proposalName:"VENEZUELA-19-ALLIED-COMMUNITIES",
		proposalUrl:"https://www.dashninja.pl/proposaldetails.html?proposalhash=cdaa65e7dca8e6825350d06510462a901f03aa80540af721bc125bdcb7bb3f5a",
		dashAmountRequested:167,
		donationSofttarget:167,	
		dashAlreadyReceivedToAddress:5,
		dashAddress:"XtVqTjBK1UsCe8a1iX6enjB7MBJZDzWvUV",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		isPastDonation:false ).save(flush:true)
	

		new ProposalDonationInfo(proposalName:"Dash Embassy DACH",
		proposalUrl:"https://www.dashninja.pl/proposaldetails.html?proposalhash=197ca53aa00d405992d4a4802d098732748a05839f0fd3d718035a66ebcb7a2a",
		dashAmountRequested:408,
		donationSofttarget:250,	
		dashAlreadyReceivedToAddress:1324.4877,
		dashAddress:"XuMeunJDZrAusw45B4oreuH8RcKUY2fkMN",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		isPastDonation:false ).save(flush:true)
	
		new ProposalDonationInfo(proposalName:"AgroCognitive dash powered",
		proposalUrl:"https://www.dashninja.pl/proposaldetails.html?proposalhash=cebf75316f05c0400c17f0d069bb23da7bd6e1536653a3f291282f5580e4b167",
		dashAmountRequested:191,
		donationSofttarget:91,
		dashAddress:"XngJk1Mut7tXBRnAgz93oAQZ7apfUPrETU",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		donationPeriodStartDate:new Date().parse("yyyy-MM-dd","2018-08-01"),
		donationPeriodEndDate:new Date().parse("yyyy-MM-dd","2018-09-01"),isPastDonation:false ).save(flush:true)


//-------------------done to here..
	///------------PAST PROPOSALS--------------------------


        break

	}

    }
    def destroy = {
    }
}

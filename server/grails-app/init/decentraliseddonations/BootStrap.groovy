package decentraliseddonations
import grails.util.Environment
import org.decentraliseddonations.*


class BootStrap {

    def init = { servletContext ->

    



	switch (Environment.current) {
    case Environment.DEVELOPMENT:
    case Environment.PRODUCTION:

		new ProposalDonationInfo(proposalName:"VENEZUELA-19-ALLIED-COMMUNITIES (address by eugenialcala on reddit)",
		proposalUrl:"https://www.reddit.com/r/dashpay/comments/954yd9/crowdfunding_for_dash_venezuela_communities/",
		dashAmountRequested:167,
		donationSofttarget:167,	
		dashAlreadyReceivedToAddress:0,
		dashAddress:"XmfbSqw5WzSn962HKjxiAr4s3rnHS9G5yT",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		isPastDonation:false ).save(flush:true)
	

		new ProposalDonationInfo(proposalName:"1st DASH Conference Trujillo Venezuela",
		proposalUrl:"https://www.dash.org/forum/threads/pre-proposal-1st-dash-conference-trujillo-venezuela-850-000-people.37252/",
		dashAmountRequested:81.9633,
		donationSofttarget:40.9817,	
		dashAlreadyReceivedToAddress:0,
		dashAddress:"XtR9Aac8TuRYdkA4QcmH855uVA9zsoKjhB",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		isPastDonation:false ).save(flush:true)
	


		new ProposalDonationInfo(proposalName:"Dash Embassy DACH escrowed by greencandle (check #green_candle channel on discord)",
		proposalUrl:"https://www.reddit.com/r/dashpay/comments/93pljw/the_dash_embassy_dach_needs_your_support_for/e3he6kj",
		dashAmountRequested:408,
		donationSofttarget:250,	
		dashAlreadyReceivedToAddress:0,
		dashAddress:"XiLJruPZAVbpPh13nw7urAygPhqYDfH3Md",
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



		new ProposalDonationInfo(proposalName:"Specialized Course for Merchants/Maracay-Venezuela  (For each 7.5 dash, we will do one course)",
		proposalUrl:"https://www.dashninja.pl/proposaldetails.html?proposalhash=c60dfec0464c35f5a0ebd55d59a5bcb6b8bf14819eb456d95317dffac02db825",
		dashAmountRequested:60,
		donationSofttarget:7.5,
		dashAddress:"XnHSP4JuHfoC98o44dHDPfP3BjX5yMqozH",
		indicatedDashDonationAmountByPotentialDonors:0,
		currentAmountDonated:0,
		donationPeriodStartDate:new Date().parse("yyyy-MM-dd","2018-08-01"),
		donationPeriodEndDate:new Date().parse("yyyy-MM-dd","2018-09-01"),isPastDonation:false ).save(flush:true)

		new ProposalDonationInfo(proposalName:"Huitpro - Dash Freelance Marketplace.",
		proposalUrl:"https://www.dashninja.pl/proposaldetails.html?proposalhash=0b0576647c80f6c68a482ccf459d39d6441d637740ea09830afa79af1dbcd030",
		dashAmountRequested:160,
		donationSofttarget:75,
		dashAddress:"Xu4rQnp9Fd4MSQHFpv4tVGL7epnjLj6AM5",
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

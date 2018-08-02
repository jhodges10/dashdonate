package org.decentraliseddonations
//@Grapes( @Grab('org.jsoup:jsoup:*'))                                                                                                                                                            
import groovy.xml.*               
import org.jsoup.Jsoup;            
import org.jsoup.helper.Validate;                                  
import org.jsoup.nodes.Document;                                                        
import org.jsoup.nodes.Element;                                                                                        
import org.jsoup.select.Elements;                                                                              
import groovy.io.FileType                                                                                             
import java.io.IOException;         
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import grails.gorm.transactions.Transactional
import java.text.SimpleDateFormat
import groovyx.net.http.HTTPBuilder                                                                                                                                                             
import static groovyx.net.http.Method.GET                                                                                                                                                       
import static groovyx.net.http.ContentType.HTML  


@Slf4j 
@Transactional()
class ProposalDonationInfoService {


boolean lazyInit = false 

//every 10 minutes fetch new donations..
    @Scheduled(fixedDelay = 600000L) 
    @Transactional()
    def updateAmountDonated() {
		def allDonations = ProposalDonationInfo.list()
	
		log.info "Fetch new donations every 10 minutes :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
		allDonations.each { don ->
		
		if(don.dashAddress) {

			def urlString = "https://chainz.cryptoid.info/dash/api.dws?q=getreceivedbyaddress&a=$don.dashAddress"
			def http = new HTTPBuilder( urlString )                                                                                                                                                         
  http.request(GET,HTML) { req ->                                                                                                                                                               
    headers.'User-Agent' = 'Mozilla'                                                                                                                                                            
    headers.'Referer' = 'http://blog.techstacks.com/'                                                                                                                                           
                                                                                                                                                                                                
// Switch to Java to set socket timeout                                                                                                                                                         
    req.getParams().setParameter("http.socket.timeout", new Integer(5000))                                                                                                                      
                                                                                                                                                                                                
// Back to Groovy                                                                                                                                                                               
  response.success = { resp, html ->                                                                                                                                                            
  println "Server Response: ${resp.statusLine}"                                                                                                                                                 
  println "Server Type: ${resp.getFirstHeader('Server')}"                                                                                                                                       
  println "Title: ${html.HEAD.TITLE.text()}"                                                                                                                                                    
  println "amount:  ${html.text()}"                                                                                                                                                             
               		println "parsing url $urlString"
			 //Document doc = Jsoup.parse(url.text,urlString);
			 def amountDonated = html.text()


			Double newVal = Double.parseDouble(amountDonated)-don.dashAlreadyReceivedToAddress
			don.currentAmountDonated=newVal //subtract previous amount if any
                        don.save(flush:true)                                                                                                                                                         
  }                                                                                                                                                                                             
  response.failure = { resp ->                                                                                                                                                                  
    println resp.statusLine                                                                                                                                                                     
  }                                                                                                                                                                                             
                                                                                                                                                                                                
                                                                                                                                                                                                
}                                                    









			}
		}
	

    }
}

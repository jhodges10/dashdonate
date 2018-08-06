import React, { Component } from 'react';
import { Grid } from 'react-bootstrap';
import AppNav from './AppNav';

import grailsLogo from './images/grails-cupsonly-logo-white.svg';
import reactLogo from './images/logo.svg';
import charityLogo from './images/charity.png';

import { SERVER_URL, CLIENT_VERSION, REACT_VERSION } from './config';
import 'whatwg-fetch';
import Circle from 'react-circle';
import { Flex, Box } from 'reflexbox';
import QRCode from 'qrcode.react';

class App extends Component {

  constructor() {
    super();

    this.state = {
      serverInfo: {},
      clientInfo: {
        version: CLIENT_VERSION,
        react: REACT_VERSION
      }
    }
  }

  componentDidMount() {
    fetch(SERVER_URL + '/application')
      .then(r => r.json())
      .then(json => this.setState({serverInfo: json}))
      .catch(error => console.error('Error connecting to server: ' + error));


	     fetch(SERVER_URL + '/api/proposaldonationinfo')
	           .then(r => r.json())
		   .then(json => this.setState({pdinfos: json}))
		   .catch(error => console.error('Error retrieving proposal donation informations: ' + error));



  }

  render() {
    const serverInfo = this.state.serverInfo;
    const clientInfo = this.state.clientInfo;
    const pdinfos = this.state.pdinfos;
    const numCols = 5;

    return (
      <div>
        <div className="grails-logo-container">
          <img className="grails-logo" src={charityLogo} alt="Grails" />
          <span className="plus-logo">+</span>
          <img className="hero-logo" src={reactLogo} alt="Dash" />
        </div>

          <div id="content">
            <section className="row colset-2-its">
              <h1 style={{textAlign: 'center'}}>Welcome to Dash Donations</h1>
              <br/>
              <p>
                Below you can find a list of proposals that did not get funded the last voting cycle. For security reasons in the normal case each proposal has the original dash address requested in the proposal or an escrowed address so you can double check that by clicking each proposal link below. The site is automatically updated every 10 minutes. One proposal, dash venezuela 19 allied communities,have several other addresses being used and we are working on a solution to reflect those sums beeing received also, so do not worry if you sent to one of the other addresses, because that will be shown also later on.
              </p>

	      <p>
	      LEGAL DISCLAIMER: This site only provides already existing information that exists in the dash network and or in each proposal object and or in the forums such as receiving address. We do not suggest or propose that donations should be made. This site is for information purposes only. It is up to each individual to provide legal justification for each transaction made in blockchain networks, and its up to each receiver and sender to follow the rules of their respective country. Consider the rules of your country and the receiving country when sending a transaction if there are limits to each transaction. The creator(s) of this site does not take or accept any liability or cannot be held responsible for any usage of blockchain technology that any user might take due to the information provided on this website. 
	      
	      <p><b>Implicit Agreement</b>. By using our Website, you implicitly signify your agreement to all parts of the above disclaimer. 
	      </p>
	      
	      </p>

<p id="propInfos">
			
				
			<Flex wrap align='center'
		       	mt={3}	
    			style={{
			textTransform: 'uppercase'
			}}	
    			>
                        
			
			<Box w={1/numCols} p={1}>Proposal</Box> 
		    	<Box w={1/numCols} p={1}>Donated</Box>
                        <Box w={1/numCols} p={1}>Minimum target</Box> 
			<Box w={1/numCols} p={1}>Dash Address</Box> 
			<Box w={1/numCols} p={1}>QR</Box> 
			</Flex>
			
			{pdinfos ? pdinfos.map(pdinf => {
		
		
    			var dashAddress = pdinf.dashAddress;
			if(!dashAddress)
				dashAddress="not provided";

	    return    <Flex wrap align='center'>
		    	
                        <Box p={1} w={1/numCols}><a href={pdinf.proposalUrl}>{pdinf.proposalName}</a> requests {pdinf.dashAmountRequested} dash and a minimum of {pdinf.donationSofttarget} Dash</Box> 
			
			<Box p={1} w={1/numCols}><Circle progress={Number.parseFloat(pdinf.percentageDonatedOfRequested).toFixed(2)}></Circle></Box>
		    	<Box p={1} w={1/numCols}><Circle progress={Number.parseFloat(pdinf.percentageDonatedOfSoft).toFixed(2)}></Circle></Box>
			
			
			<Box p={1} w={1/numCols}>{dashAddress}</Box> 
			
			<Box p={1} w={1/numCols}><QRCode value={dashAddress} size={64}></QRCode></Box> 
			</Flex>				
							
							
							
							
							
							}) : null 
			
			}
            
				
</p>				



            </section>

          </div>
      </div>
    );
  }
}

export default App;

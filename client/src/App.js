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
                Below you can find a list of proposals that did not get funded the last voting cycle. Please consider donating to the proposals to see further progress for dash. Each proposal owner has been contacted to get approval for donations and a minimum amount requested. For security reasons each proposal has the original dash address requested in the proposal so you can double check that on dashninja by clicking each proposal link below. The donated amount is automatically updated every 10 minutes, so do not worry if you cannot se an increase in the percent straight away after donating.
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

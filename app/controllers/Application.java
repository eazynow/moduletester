package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import exceptions.playmodauthn.AdapterConfigurationException;

import adapters.playmodauthn.appgateway.AuthnAPIAdapterImpl;

import models.*;

public class Application extends controllers.playmodauthn.APIController {

    public static void index() {
    	
    	try {
    		
    		AuthnAPIAdapterImpl api = new AuthnAPIAdapterImpl();
    		StringBuilder sb = new StringBuilder();
    		sb.append("{");
    		try{
    		sb.append("\"user_id\":\"");
    		sb.append(identifyCurrentUserOrError());
    		sb.append("\",\"app_id\":\"");
    		sb.append(getCurrentApplicationIdOrError());
    		sb.append("\",");
    		}
    		
    		catch(Exception ex){
    			
    		}
    		sb.append("\"access_token\":\"");
    		
    		//sb.append(api.getAccessToken("rob.baines@yellglobal.com", "Newday01"));
    		sb.append("\"}");

			renderText(sb.toString());

		} catch (AdapterConfigurationException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
    	
    }

}
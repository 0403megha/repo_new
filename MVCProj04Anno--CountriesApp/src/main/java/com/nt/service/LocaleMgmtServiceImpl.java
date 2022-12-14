package com.nt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;


@Service("localeService")
public class LocaleMgmtServiceImpl implements ILocaleMgmtService{

	@Override
	public List<String> fetchAllCountries() {
	    //get All Locales of the world
        Locale local[]=Locale.getAvailableLocales();
        List<String> listCountries=new ArrayList<String>();
        for(Locale l:local) {
        	if(l!=null && l.getDisplayLanguage().length()!=0) 
        		listCountries.add(l.getCountry());	
        }
        Collections.sort(listCountries);
		return listCountries;
	}

}

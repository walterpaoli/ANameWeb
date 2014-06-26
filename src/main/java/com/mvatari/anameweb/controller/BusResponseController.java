package com.mvatari.anameweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mvatari.aname.beans.Bus;

@Controller
public class BusResponseController {
	public static String BUSAPI_URL = "http://localhost:8080/AName/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/request_buses", method=RequestMethod.POST)
	public ModelAndView requestBuses(){
		// Obtener el bean
//		List<Bus> buses = restTemplate.getForObject(BUSAPI_URL + "/buses", List.class);
		MultiValueMap<String, String> parametros = new LinkedMultiValueMap<String, String>();
		parametros.add("access_token", "123456");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		List<Bus> buses = restTemplate.postForObject(BUSAPI_URL + "/buses", parametros, List.class);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parametros, headers);
		ResponseEntity<List<Bus>> respuesta = restTemplate.exchange(BUSAPI_URL + "/buses", 
												HttpMethod.POST, 
												request, 
												new ParameterizedTypeReference<List<Bus>>(){});
		 List<Bus> buses = respuesta.getBody();
		 // Retornar el nombre de la vista a modelar
		return new ModelAndView("resultado", "busesList", buses);
	}
}

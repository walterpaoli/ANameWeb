package com.mvatari.anameweb.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		List<LinkedHashMap> buses = restTemplate.getForObject(BUSAPI_URL + "buses/", List.class);
/*		Bus b = new Bus();
		b.setID(1L);
		b.setLineNumber(100);
		b.setName("Línea directa");
		b.setVehicleStops(null);
		
		buses.add(b);

		b = new Bus();
		b.setID(2L);
		b.setLineNumber(200);
		b.setName("Línea indirecta");
		b.setVehicleStops(null);
		
		buses.add(b);*/

		// Retornar el nombre de la vista a modelar
		return new ModelAndView("resultado", "busesList", buses);
	}
}

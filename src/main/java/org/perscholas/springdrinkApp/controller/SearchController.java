package org.perscholas.springdrinkApp.controller;

import java.util.List;

import org.perscholas.springdrinkApp.entity.Alcohol;
import org.perscholas.springdrinkApp.JpsRepository.AlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kevinbusch
 *
 */
@Controller
public class SearchController {
	@Autowired
	private AlcoholRepository alc;

	
	@RequestMapping("/searchMain")
	public ModelAndView searchAll(@RequestParam("alcohol")String name) {
		System.out.println("got to search main");
		ModelAndView mav = new ModelAndView("results");
		List<Alcohol> alcohol = alc.findByNameLKeyword(name);
		for (Alcohol alcohol2 : alcohol) {
			System.out.println(alcohol2);
		}
		System.out.println("got to show");
		mav.addObject("alc", alcohol);
		return mav;
	}
	@RequestMapping("/searchAgain")
	public ModelAndView searchAgain(@RequestParam("alcohol")String name) {
		System.out.println("got to search main");
		ModelAndView mav = new ModelAndView("results");
		List<Alcohol> alcohol = alc.findByNameLKeyword(name);
		for (Alcohol alcohol2 : alcohol) {
			System.out.println(alcohol2);
		}
		System.out.println("got to show");
		mav.addObject("alc", alcohol);
		return mav;
	}

}

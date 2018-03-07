package com.elsoprojekt.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elsoprojekt.domain.Story;
import com.elsoprojekt.repository.StoryRepository;
import com.elsoprojekt.service.StoryService;

@Controller
public class HomeController {
	
	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle", "Minden napre egy SFJ sztori");
		model.addAttribute("stories", storyService.getStories());
		System.out.println(String.format("Request received. Language: %s, Counry: %s %n",  locale.getLanguage(), locale.getDisplayCountry()));
		return "stories";
	}
	
	@RequestMapping("/story")
	public String story(Model model) {
		model.addAttribute("pageTitle", "Minden napre egy SFJ sztori");
		model.addAttribute("story", storyService.getStory());
		return "story";
	}
	
	@RequestMapping("/title/{title}")
	public String searchForStory(@PathVariable(value="title") String title, Model model) throws Exception {
		if(title == null)
			throw new Exception("Nincs ilyen címmel sztorink");
		model.addAttribute("story", storyService.getSpecificStory(title));
		return "story";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest ra, Exception ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "exceptionHandler";
	}
	
//	private List<Story> getStories() {
//		
//		List<Story> stories = storyRepo.findAll();
//		
//		return stories;
//		ArrayList<Story> stories = new ArrayList<>();
		
//		Story story1 = new Story();
//		story1.setTitle("Első sztorim");
//		story1.setPosted(new Date());
//		story1.setAuthor("Bob");
//		story1.setContent("<p>Na ez az adat már éles adat.</p>");
//		
//		Story story2 = new Story();
//		story2.setTitle("Második sztorim");
//		story2.setPosted(new Date());
//		story2.setAuthor("Gyula");
//		story2.setContent("<p>Gyula története senkit nem érdekel.</p>");
//		
//		stories.add(story1);
//		stories.add(story2);
		
//		return stories;
		
//	}
}

package com.elsoprojekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsoprojekt.domain.Story;
import com.elsoprojekt.service.StoryService;

@RestController
public class ApiController {


	private StoryService storyService;

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/story")
	public Story story() {
		return storyService.getStory();
	}

	@RequestMapping("/title/{title}")
	public Story searchForStory(@PathVariable(value="title") String title) {
		return storyService.getSpecificStory(title);
	}
	
	@RequestMapping("/stories/{name}")
	public List<Story> searchForStoriesByBloggerName(@PathVariable(value="name") String name) {
		return storyService.getStoriesByBloggerName(name);
	}
}

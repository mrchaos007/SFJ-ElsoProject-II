package com.elsoprojekt.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsoprojekt.domain.Blogger;
import com.elsoprojekt.domain.Story;
import com.elsoprojekt.repository.BloggerRepository;
import com.elsoprojekt.repository.StoryRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;
	
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}
	
//	@PostConstruct
//	public void init() {
//		Blogger blogger = new Blogger("Belső Gyula", 25);
//		bloggerRepo.save(blogger);
//		
//		Story story = new Story("Belső cím", "Belső tartalom", new Date(), blogger);
//		storyRepo.save(story);
//	}
	
}
